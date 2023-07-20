package com.teknokafalar.piabackend.dto.response;

import lombok.Data;

@Data
public class CommentResponse {
    private String firstName;
    private String text;
    private String lastName;
    private String email;
    private Long bookId;
}
