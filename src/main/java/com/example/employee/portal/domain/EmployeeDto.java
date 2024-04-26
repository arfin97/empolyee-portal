package com.example.employee.portal.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    @NotEmpty(message = "The full name is required.")
    private String name;
    private String designation;
    private String phoneNumber;

    @Override
    public String toString() {
        return "UNGABUNGA{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
