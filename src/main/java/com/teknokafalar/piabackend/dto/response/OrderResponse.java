package com.teknokafalar.piabackend.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teknokafalar.piabackend.entities.OrderItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private Long id;

    private Long userId;

    private List<OrderItem> orderItems;

    private String orderCode;

    private Boolean orderStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime orderDate;


    private Double totalPrice;
}
