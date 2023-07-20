package com.teknokafalar.piabackend.dto.response;

import lombok.Data;

@Data
public class BookResponse {
    private double price;
    private double stock;

    private String name;

    private String year;

    private String bookSummary;

    private String publisher;

    private String imagesUrl;
    private Long authorId;
    private Long typeId;
}