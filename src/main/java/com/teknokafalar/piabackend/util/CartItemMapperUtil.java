package com.teknokafalar.piabackend.util;

import com.teknokafalar.piabackend.dto.request.CartItemRequest;
import com.teknokafalar.piabackend.dto.response.CartItemResponse;
import com.teknokafalar.piabackend.entities.Book;
import com.teknokafalar.piabackend.entities.CartItem;
import com.teknokafalar.piabackend.repository.BookRepository;
import com.teknokafalar.piabackend.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CartItemMapperUtil {
    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;

    public CartItem toCartItem(CartItemRequest request)  {
        Book bookOptional = this.bookRepository.findById(request.getBookId()).get();
        Book book = bookOptional;

        CartItem cartItem = new CartItem();
        cartItem.setQuantity(request.getQuantity());
        cartItem.setTotalPrice(request.getTotalPrice());
        cartItem.setBook(book);
        return cartItem;

    }

    public static CartItemResponse toCartItemResponse(CartItem cartItem) {
        CartItemResponse response = new CartItemResponse();
        response.setTotalPrice(cartItem.getTotalPrice());
        response.setQuantity(cartItem.getQuantity());
        response.setBookId(cartItem.getBook().getId());
        return response;
    }

}
