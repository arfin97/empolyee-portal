package com.example.employee.portal.aspect;

import com.example.employee.portal.service.JWTService;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AuthorizationAspect {

    @Autowired
    private JWTService jwtService; // Service to validate JWT

    @Pointcut("@annotation(Authorize)")
    public void authorizeMethods() {}

    @Around("authorizeMethods()")
    public Object authenticateToken(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = getTokenFromHeader(request);

        if (token == null || !jwtService.validateToken(token)) {
            throw new SecurityException("Invalid or missing authentication token.");
        }

        return joinPoint.proceed(); // Proceed only if the token is valid
    }

    private String getTokenFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}

