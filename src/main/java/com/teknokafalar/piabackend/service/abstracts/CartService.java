package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.dto.request.CartRequest;
import com.teknokafalar.piabackend.dto.response.CartResponse;

import java.util.List;

public interface CartService {
    List<CartResponse> getCart();
    Result postCart(CartRequest request, Long userId);
    CartResponse updateCart(CartRequest request, Long cartId);
    CartResponse deleteCart(Long cartId) ;
}
