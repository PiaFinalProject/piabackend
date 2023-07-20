package com.teknokafalar.piabackend.excepiton;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException() {
        super("Id not found");
    }
}
