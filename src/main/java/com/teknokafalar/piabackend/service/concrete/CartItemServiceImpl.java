package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.dto.request.CartItemRequest;
import com.teknokafalar.piabackend.dto.response.CartItemResponse;
import com.teknokafalar.piabackend.entities.Book;
import com.teknokafalar.piabackend.entities.CartItem;
import com.teknokafalar.piabackend.repository.BookRepository;
import com.teknokafalar.piabackend.repository.CartItemRepository;
import com.teknokafalar.piabackend.service.abstracts.CartItemService;
import com.teknokafalar.piabackend.util.CartItemMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;
    private final CartItemMapperUtil mapperUtil;
    @Override
    public List<CartItem> getCartItem() {
        return this.cartItemRepository.findAll();
    }

    @Override
    public CartItemResponse postCartItem(CartItemRequest request) {
        CartItem cartItem = mapperUtil.toCartItem(request);
        CartItem cartItemBook = cartItemRepository.save(cartItem);
        return CartItemMapperUtil.toCartItemResponse(cartItemBook);
    }

    @Override
    public CartItemResponse updateCartItem(CartItemRequest request, Long cartItemId) {
        Optional<CartItem> cartItemDb = this.cartItemRepository.findById(cartItemId);
        Optional<Book> bookDb = this.bookRepository.findById(request.getBookId());
        CartItem cartItem = null;
        if (cartItemDb.isPresent()) {
            cartItem =cartItemDb.get();
            cartItem.setTotalPrice(request.getPrice());
            cartItem.setQuantity(request.getQuantity());
            cartItem.setTotalPrice(request.getTotalPrice());
            if (bookDb.isPresent()) {
                Book book = bookDb.get();
                cartItem.setBook(book);
            }
        }
        CartItem updateCartItem =   cartItemRepository.save(cartItem);
        return CartItemMapperUtil.toCartItemResponse(updateCartItem);
    }

    @Override
    public CartItemResponse deleteCartItem(Long cartItemId) {
        Optional<CartItem> cartItemDb = this.cartItemRepository.findById(cartItemId);
        CartItem cartItem = cartItemDb.get();
        this.bookRepository.deleteById(cartItemId);
        return CartItemMapperUtil.toCartItemResponse(cartItem);
    }
}
