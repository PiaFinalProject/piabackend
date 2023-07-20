package com.teknokafalar.piabackend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double quantity;

    private double totalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId", nullable = true)
    private Book book;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId", nullable = true)
    private Cart cart;


}
