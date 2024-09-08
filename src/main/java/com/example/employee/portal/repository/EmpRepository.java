package com.example.employee.portal.repository;

import com.example.employee.portal.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<EmployeeEntity, Long> {
}
