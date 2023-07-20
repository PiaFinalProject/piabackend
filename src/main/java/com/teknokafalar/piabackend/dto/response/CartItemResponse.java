package com.teknokafalar.piabackend.dto.response;

import com.teknokafalar.piabackend.entities.Book;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
public class CartItemResponse {


    private double price;
    private double quantity;

    private double totalPrice;

    private Long bookId;
}
