package com.teknokafalar.piabackend.dto.request;

import lombok.Data;

@Data
public class BookRequest {

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
