package com.example.employee.portal.controller;


import com.example.employee.portal.domain.EmployeeDto;
import com.example.employee.portal.entity.EmployeeEntity;
import com.example.employee.portal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Read API
    @GetMapping("/employees")
    public Page<EmployeeEntity> getAllEmployee(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "asc") String sortOrder) {
        return employeeService.getAllEmployee(page, size, sortOrder);
    }

    //Read API
    @GetMapping("/employees/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    //Read by name API
    @GetMapping("/employees/by")
    public EmployeeDto getEmployeeByName(@RequestParam String name) {
        return employeeService.getEmployeeByName(name);
    }


    //Create API
    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    //Update API
    @PutMapping("/employees/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(id, employeeDto);
    }

    //Delete API
    @DeleteMapping("/employees/{id}/delete")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}
