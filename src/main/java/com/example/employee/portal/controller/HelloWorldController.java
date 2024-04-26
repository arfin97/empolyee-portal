package com.example.employee.portal.controller;

import com.example.employee.portal.domain.EmployeeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(Model model) {
        List<EmployeeDto> employeeDtoList = List.of(
                new EmployeeDto("Alamin Doe", "Software Engineer", "1234567890"),
                new EmployeeDto("Shahed Joe", "Admin", "1234567890"),
                new EmployeeDto("Jeba Poe", "Software Engineer", "1234567890"),
                new EmployeeDto("Baber Koe", "Software Engineer", "1234567890")
        );
        model.addAttribute("employees", employeeDtoList);
        return "hello";
    }
}
