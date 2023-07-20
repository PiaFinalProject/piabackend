package com.teknokafalar.piabackend.controller;

import com.teknokafalar.piabackend.core.utilities.results.DataResult;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;
import com.teknokafalar.piabackend.dto.request.OrderRequest;
import com.teknokafalar.piabackend.dto.response.OrderResponse;
import com.teknokafalar.piabackend.service.abstracts.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
    private final OrderService service;

    @GetMapping("/list")
    public DataResult<List<OrderResponse>> getUserorders(@RequestParam Long userId) {
        return service.getUserOrders(userId);
    }

    @PostMapping("/save")
    public Result postOrder(@RequestBody OrderRequest request) {
        return new SuccessDataResult<>(this.service.postOrder(request),"added author" );
    }

}
