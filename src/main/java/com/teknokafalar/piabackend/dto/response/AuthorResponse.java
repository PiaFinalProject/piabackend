package com.teknokafalar.piabackend.dto.response;

import lombok.Data;

@Data
public class AuthorResponse {
    private Long id;

    private String firstName;
    private String lastName;
    private String birthday;
    private String about;
}
