package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.dto.request.BookRequest;
import com.teknokafalar.piabackend.dto.request.CartItemRequest;
import com.teknokafalar.piabackend.dto.response.BookResponse;
import com.teknokafalar.piabackend.dto.response.CartItemResponse;
import com.teknokafalar.piabackend.entities.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> getCartItem();
    CartItemResponse postCartItem(CartItemRequest request);
    CartItemResponse updateCartItem(CartItemRequest request, Long cartItemId    );
    CartItemResponse deleteCartItem(Long bookId) ;
}
