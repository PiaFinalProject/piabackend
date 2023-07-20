package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.core.utilities.results.DataResult;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.dto.request.BookRequest;
import com.teknokafalar.piabackend.dto.request.OrderRequest;
import com.teknokafalar.piabackend.dto.response.BookResponse;
import com.teknokafalar.piabackend.dto.response.OrderResponse;
import com.teknokafalar.piabackend.entities.Book;
import com.teknokafalar.piabackend.entities.Order;

import java.util.List;

public interface OrderService {
    DataResult<List<OrderResponse>> getUserOrders(Long userId);
    Result postOrder(OrderRequest request) ;
    OrderResponse updateOrderResponse(OrderRequest request, Long bookId);
    OrderResponse deleteOrderResponse(Long bookId) ;
}
