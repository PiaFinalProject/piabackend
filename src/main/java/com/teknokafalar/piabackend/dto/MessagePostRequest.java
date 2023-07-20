package com.teknokafalar.piabackend.dto;

import lombok.Data;

@Data
public class MessagePostRequest {
    private String firstName;
    private String lastName;
    private String currentBook;
    private String eMail;
    private String messageSubject;
}
