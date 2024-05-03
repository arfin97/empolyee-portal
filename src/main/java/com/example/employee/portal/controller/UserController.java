package com.example.employee.portal.controller;

import com.example.employee.portal.domain.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showForm(Model model) {
        UserDto attributeValue = new UserDto();
        model.addAttribute("user", attributeValue);
        model.addAttribute("user", attributeValue);
        model.addAttribute("user", attributeValue);
        model.addAttribute("user", attributeValue);
        return "register";
    }

    @PostMapping("/register")
    public String user(@ModelAttribute UserDto user, Model model) {
        model.addAttribute("message", "User registered successfully!");
        model.addAttribute("user", new UserDto());
        System.out.println(user.getName());
        return "register";
    }
}
