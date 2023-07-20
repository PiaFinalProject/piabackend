package com.teknokafalar.piabackend.dto.response;

import com.teknokafalar.piabackend.entities.Book;
import com.teknokafalar.piabackend.entities.Cart;
import com.teknokafalar.piabackend.entities.CartItem;
import com.teknokafalar.piabackend.entities.User;
import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data

public class CartResponse {
    private double quantity;

    private double totalPrice;

    private String bookName;

}
