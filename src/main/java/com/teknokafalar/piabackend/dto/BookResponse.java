package com.teknokafalar.piabackend.dto;

import lombok.Data;

@Data
public class BookResponse {
    private Long id;

    private String name;

    private String year;

    private String bookSummary;

    private String publisher;

    private String imagesUrl;
    private Long authorId;
    private Long typeId;
}
