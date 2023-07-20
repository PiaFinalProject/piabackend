package com.teknokafalar.piabackend.dto.request;

import lombok.Data;

@Data
public class CartItemRequest {
    private double price;
    private double quantity;

    private double totalPrice;

    private Long bookId;

}
