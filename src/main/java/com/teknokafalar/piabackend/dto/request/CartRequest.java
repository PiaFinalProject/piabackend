package com.teknokafalar.piabackend.dto.request;

import lombok.Data;
@Data

public class CartRequest {
    private Long quantity;

    private Long bookId;
}
