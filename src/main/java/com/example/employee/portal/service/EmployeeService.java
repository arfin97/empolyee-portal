package com.example.employee.portal.service;

import com.example.employee.portal.domain.EmployeeDto;
import com.example.employee.portal.entity.EmployeeEntity;
import com.example.employee.portal.exceptions.RecordNotFound;
import com.example.employee.portal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Create Employee API
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        //MAPPING DTO TO ENTITY
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setDesignation(employeeDto.getDesignation());
        employeeEntity.setPhoneNumber(employeeDto.getPhoneNumber());
        employeeRepository.save(employeeEntity);

        return employeeDto;
    }

    //Read Employee API
    public EmployeeDto getEmployee(Long id) {
        //FETCHING EMPLOYEE ENTITY
        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();

        if(employeeOptional.isEmpty()) {
            throw new RecordNotFound("Employee not found for the id: " + id);
        }

        if (employeeOptional.isPresent()) {
            EmployeeEntity employeeEntity = employeeOptional.get();
            employeeDto.setName(employeeEntity.getName());
            employeeDto.setDesignation(employeeEntity.getDesignation());
            employeeDto.setPhoneNumber(employeeEntity.getPhoneNumber());
        }

        return employeeDto;
    }

    //Update Employee API
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);
        EmployeeEntity employeeEntity;
        if (employeeOptional.isPresent()) {
            employeeEntity = employeeOptional.get();
            employeeEntity.setName(employeeDto.getName());
            employeeEntity.setDesignation(employeeDto.getDesignation());
            employeeEntity.setPhoneNumber(employeeDto.getPhoneNumber());
        } else {
            throw new RuntimeException("Employee not found for the id: " + id);
        }

        employeeRepository.save(employeeEntity);
        return employeeDto;
    }

    //Delete Employee API
    public String deleteEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeEntity);
        return "Employee Deleted";
    }

//    public List<EmployeeDto> getAllEmployee(int pageNumber, int pageSize, String sortOrder) {
//
//        Sort sort = sortOrder.equals("asc") ? Sort.by("name").ascending() : Sort.by("name").descending();
//        Pageable paging = PageRequest.of(pageNumber, pageSize, sort);
//        Page<EmployeeEntity> pageContent = employeeRepository.findAll(paging);
//
//
//        List<EmployeeEntity> all = pageContent.getContent();
//
//        List<EmployeeDto> employeeDtos = new ArrayList<>();
//        for (EmployeeEntity employeeEntity : all) {
//            EmployeeDto employeeDto = new EmployeeDto();
//            employeeDto.setName(employeeEntity.getName());
//            employeeDto.setDesignation(employeeEntity.getDesignation());
//            employeeDto.setPhoneNumber(employeeEntity.getPhoneNumber());
//            employeeDtos.add(employeeDto);
//        }
//
//        return employeeDtos;
//    }

    public Page<EmployeeEntity> getAllEmployee(int pageNumber, int pageSize, String sortOrder) {

        Sort sort = sortOrder.equals("asc") ? Sort.by("name").ascending() : Sort.by("name").descending();
        Pageable paging = PageRequest.of(pageNumber, pageSize, sort);
        Page<EmployeeEntity> pageContent = employeeRepository.findAll(paging);

        return pageContent;
    }

    public EmployeeDto getEmployeeByName(String name) {
        EmployeeEntity employeeEntity = employeeRepository.findByName(name).get();

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employeeEntity.getName());
        employeeDto.setDesignation(employeeEntity.getDesignation());
        employeeDto.setPhoneNumber(employeeEntity.getPhoneNumber());

        return employeeDto;
    }
}
