package com.example.employee.portal.controller;

import com.example.employee.portal.aspect.Authorize;
import com.example.employee.portal.domain.EmployeeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping("/hello")
    @Authorize
    public String hello(Model model) {
        model.addAttribute("message", "Hello World!");
//        model.addAttribute("employees", employees);
        return "helloworldview";
    }

}
