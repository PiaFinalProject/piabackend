package com.teknokafalar.piabackend.dto;

import lombok.Data;

@Data
public class CommentPostRequest {
    private String firstName;
    private String text;
    private String lastName;
    private String email;
    private Long bookId;
}
