package com.example.employee.portal.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {


    // catch runtime exception
    // return response object with message and status code
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorObject> handleRuntimeException(RuntimeException e) {
        ErrorObject responseObject = new ErrorObject();
        responseObject.setMessage(e.getMessage());
        responseObject.setStatusCode("C500");
        return ResponseEntity.status(500).body(responseObject);
    }

    @ExceptionHandler(RecordNotFound.class)
    public ResponseEntity<ErrorObject> handleRuntimeException(RecordNotFound e, WebRequest request) {
        ErrorObject responseObject = new ErrorObject();
        responseObject.setMessage("Record not found");
        responseObject.setStatusCode("C404");
        return ResponseEntity.status(404).body(responseObject);
    }

}
