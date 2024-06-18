package com.example.springbootut.springbootut.error;

import com.example.springbootut.springbootut.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DeptNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DeptNotFoundException deptNotFoundException, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,deptNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
