package com.example.employee.portal.service;

import com.example.employee.portal.domain.EmployeeDto;
import com.example.employee.portal.entity.EmployeeEntity;
import com.example.employee.portal.repository.EmpRepository;
import com.example.employee.portal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto getEmployee(Long id) {
        Optional<EmployeeEntity> employeeEntityOptional = empRepository.findById(id);
        EmployeeEntity employeeEntity = employeeEntityOptional.get();

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employeeEntity.getName());
        employeeDto.setDesignation(employeeEntity.getDesignation());
        employeeDto.setPhoneNumber(employeeEntity.getPhoneNumber());

        return employeeDto;
    }

    public List<EmployeeEntity> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = empRepository.findAll();
        return employeeEntities;
    }

    public EmployeeEntity saveEmployee(EmployeeDto employeeDto){
        //CREATING ENTITY OBJECT
        EmployeeEntity employeeEntity = new EmployeeEntity();
        //MAPPING DTO TO ENTITY
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setDesignation(employeeDto.getDesignation());
        employeeEntity.setPhoneNumber(employeeDto.getPhoneNumber());
        //SAVING ENTITY TO DB
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return savedEmployee;
    }

    public void deleteEmployee(Long id) {
        empRepository.deleteById(id);
    }

    public EmployeeEntity updateEmployee(Long id, EmployeeDto employeeDto){
        Optional<EmployeeEntity> employeeEntity = empRepository.findById(id);
        if(employeeEntity.isPresent()){
            EmployeeEntity updatedEmployee = employeeEntity.get();
            if(employeeDto.getName() != null){
                updatedEmployee.setName(employeeDto.getName());
            }
            if(employeeDto.getDesignation() != null){
                updatedEmployee.setDesignation(employeeDto.getDesignation());
            }
            if(employeeDto.getPhoneNumber() != null){
                updatedEmployee.setPhoneNumber(employeeDto.getPhoneNumber());
            }
            return empRepository.save(updatedEmployee);
        }
        else {
            throw new RuntimeException("Employee not found for the id: " + id);
        }
    }

}
