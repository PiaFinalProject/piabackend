package com.teknokafalar.piabackend.dto.request;

import lombok.Data;

@Data
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}
