package com.example.employee.portal.repository;

import com.example.employee.portal.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findByName(String name);
    Optional<EmployeeEntity> findByNameAndDesignation(String name, String designation);
}
