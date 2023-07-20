package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.core.utilities.results.*;
import com.teknokafalar.piabackend.dto.request.OrderRequest;
import com.teknokafalar.piabackend.dto.response.OrderResponse;
import com.teknokafalar.piabackend.entities.*;
import com.teknokafalar.piabackend.repository.BookRepository;
import com.teknokafalar.piabackend.repository.CartRepository;
import com.teknokafalar.piabackend.repository.OrderRepository;
import com.teknokafalar.piabackend.repository.UserRepository;
import com.teknokafalar.piabackend.service.abstracts.OrderService;
import com.teknokafalar.piabackend.util.OrderMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    private final BookRepository bookRepository;
    private final OrderMapperUtil mapperUtil;


    @Override
    public Result postOrder(OrderRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new IllegalArgumentException("Kullanıcı bulunamadı."));
     /*   Random random = new Random();
        Long randomNumber = (long) random.nextInt(1000);*/
        Cart cart = user.getCart();
        List<CartItem> cartItems = cart.getCartItems();
        //PaymentType paymentType = paymentTypeService.findById(createOrderRequest.getPaymentTypeId());


        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        //order.setOrderCode((long) randomNumber);
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            Book book = cartItem.getBook();
            double quantity = cartItem.getQuantity();

            if (book.getStock() >= quantity) {
                OrderItem orderItem = new OrderItem();
                orderItem.setBook(book);
                orderItem.setQuantity(quantity);
                orderItem.setTotalItemPrice(cartItem.getTotalPrice());
                orderItems.add(orderItem);
                orderItem.setOrder(order);

                book.setStock(book.getStock()-quantity);
                bookRepository.save(book);
            }
        }
        order.setOrderItems(orderItems);
        order.setOrderStatus(false);
        order.setTotalOrderPrice(cart.getTotalPrice());
        cartItems.clear();
        cart.setTotalPrice(0);
        userRepository.save(user);
        orderRepository.save(order);
        return new SuccessResult("Created");
    }



    public DataResult<List<OrderResponse>> getUserOrders(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return new ErrorDataResult<>(null, "No such user exists.");
        }

        List<Order> orders = user.getOrders();
        List<OrderItem> orderItems = orders.stream()
                .flatMap(order -> order.getOrderItems().stream())
                .collect(Collectors.toList());

        Double totalPrice = orderItems.stream()
                .mapToDouble(orderItem -> orderItem.getTotalItemPrice())
                .sum();

        OrderResponse response = new OrderResponse();
        response.setId(user.getId());
        response.setUserId(userId);
        response.setOrderItems(orderItems);
        ///response.setOrderCode(generateOrderCode()); // You can implement a method to generate order codes.
        response.setOrderStatus(true); // Assuming the orderStatus is always true for this response.
        response.setOrderDate(LocalDateTime.now()); // Set the order date as the current date and time.
        response.setTotalPrice(totalPrice);

        return new SuccessDataResult<>(response, "Data retrieved successfully");
    }

    @Override
    public OrderResponse updateOrderResponse(OrderRequest request, Long bookId) {
        return null;
    }

    @Override
    public OrderResponse deleteOrderResponse(Long bookId) {
        return null;
    }
}
