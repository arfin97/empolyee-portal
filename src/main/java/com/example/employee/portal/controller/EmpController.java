package com.example.employee.portal.controller;

import com.example.employee.portal.domain.EmployeeDto;
import com.example.employee.portal.entity.EmployeeEntity;
import com.example.employee.portal.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emp/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        return empService.getEmployee(id);
    }

    @GetMapping("/emp")
    public List<EmployeeEntity> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = empService.getAllEmployee();
        return employeeEntities;
    }

    @PostMapping("/emp/save")
    public EmployeeEntity saveUser(@RequestBody EmployeeDto employeeDto) {
        return empService.saveEmployee(employeeDto);
    }

    @DeleteMapping("/emp/{id}")
    public void deleteEmployee(@PathVariable Long id) {
         empService.deleteEmployee(id);
    }

    @PutMapping("/emp/{id}")
    public EmployeeEntity updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        return empService.updateEmployee(id, employeeDto);
    }
}
