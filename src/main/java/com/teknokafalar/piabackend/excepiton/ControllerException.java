package com.teknokafalar.piabackend.excepiton;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerException {
    @ResponseBody
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<DefaultExceptionMessage> idNotFound(IdNotFoundException e) {
        DefaultExceptionMessage message = new DefaultExceptionMessage();
        message.setMessage("Id not found");

        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(message);

    }
}
