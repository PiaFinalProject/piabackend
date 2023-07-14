package com.teknokafalar.piabackend.dto;

import lombok.Data;

@Data
public class AuthorPostRequest {
    private String firstName;
    private String lastName;
    private String birthday;
    private String about;
}
