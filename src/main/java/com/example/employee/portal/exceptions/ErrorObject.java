package com.example.employee.portal.exceptions;

import lombok.Data;

@Data
public class ErrorObject {
    private String message;
    private String statusCode;
}
