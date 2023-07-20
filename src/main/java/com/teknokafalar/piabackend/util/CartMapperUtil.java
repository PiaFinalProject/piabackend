package com.teknokafalar.piabackend.util;

import com.teknokafalar.piabackend.dto.response.CartResponse;
import com.teknokafalar.piabackend.entities.Cart;
import com.teknokafalar.piabackend.entities.CartItem;
import com.teknokafalar.piabackend.repository.CartItemRepository;
import com.teknokafalar.piabackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CartMapperUtil {
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

    /*   public Cart toCart (CartRequest request) {
           CartItem cartItemOptional = this.cartItemRepository.findById(request.getCartItemId()).get();
           CartItem  cartItem = cartItemOptional;

           User userOptional = this.userRepository.findById(request.getUserId()).get();
           User user = userOptional;
           Cart cart = new Cart();
           cart.setTotalPrice(request.getTotalPrice());
           //cart.setCartItem(cartItem);
           cart.setUser(user);

           return cart;
       }
   */
    public static List<CartResponse> cartResponseList(List<Cart> carts) {
        return carts.stream().map(cart -> toCartResponse(cart)).collect(Collectors.toList());
    }

    public static CartResponse toCartResponse(Cart cart) {
        CartResponse response = new CartResponse();
        //List<CartItem> cartItem = cart.getCartItems();
        Optional<Double> totalPrice = cart.getCartItems().stream().map(CartItem::getTotalPrice).reduce(Double::sum);
        Optional<Double> totalQuantity = cart.getCartItems().stream().map(CartItem::getQuantity).reduce(Double::sum);
        String totalBook = cart.getCartItems().stream().map(cartItem -> cartItem.getBook().getName()).collect(Collectors.joining(","));
        response.setTotalPrice(totalPrice.get());
        response.setBookName(totalBook);
        response.setQuantity(totalQuantity.get());
        return response;
    }
}
