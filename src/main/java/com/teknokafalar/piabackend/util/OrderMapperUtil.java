package com.teknokafalar.piabackend.util;

import com.teknokafalar.piabackend.dto.response.OrderResponse;
import com.teknokafalar.piabackend.entities.Order;
import com.teknokafalar.piabackend.repository.CartRepository;
import com.teknokafalar.piabackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderMapperUtil {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

  /*  public Order toOrder (OrderRequest request) {
        Cart cartOptional = this.cartRepository.findById(request.getId()).get();
        Cart cart = cartOptional;
        User userOptional = this.userRepository.findById(request.getUserId()).get();
        User user = userOptional;
        Order order = new Order();

        order.setCart(cart);
        order.setUser(user);

        return order;
    }*/
public static OrderResponse toOrderResponse(Order order) {
        OrderResponse response = new OrderResponse();
      //  response.setCartId(order.getCart().getId());
        response.setUserId(order.getUser().getId());
        return response;
    }
}

