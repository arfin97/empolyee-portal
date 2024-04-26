package com.example.employee.portal.controller;

import com.example.employee.portal.domain.EmployeeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello World!");
        List<EmployeeDto> employees = new ArrayList<>();
        employees.add(new EmployeeDto("John Doe", "Software Engineer", "1234567890"));
        employees.add(new EmployeeDto("Jane Doe", "Software Engineer", "1234567890"));
        employees.add(new EmployeeDto("Jane Doe", "Software Engineer", "1234567890"));
        employees.add(new EmployeeDto("Jane Doe", "Software Engineer", "1234567890"));
        employees.add(new EmployeeDto("Jane Doe", "Software Engineer", "1234567890"));
        model.addAttribute("employees", employees);
        return "helloworldview";
    }

}
