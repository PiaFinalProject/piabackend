package com.teknokafalar.piabackend.controller;

import com.teknokafalar.piabackend.core.utilities.results.DataResult;
import com.teknokafalar.piabackend.core.utilities.results.ErrorDataResult;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;
import com.teknokafalar.piabackend.dto.request.CartRequest;
import com.teknokafalar.piabackend.dto.response.CartResponse;
import com.teknokafalar.piabackend.service.abstracts.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {
    private final CartService service;

    @GetMapping("/list")
    public DataResult<List<CartResponse>> getCart() {
        try {

            return new SuccessDataResult<>(this.service.getCart(), "all of listed author");

        } catch (Exception e) {

            return new ErrorDataResult<>("not listed, return code");
        }

    }
    @PostMapping("/{userId}/save")
    public Result postCart(@RequestBody CartRequest request,@RequestParam Long userId) {
        return service.postCart(request,userId);

    }
    @PutMapping("/update")
    public Result updateCart(@RequestBody CartRequest request, @RequestParam Long cartItemId) {
        System.out.println(request);
        return new SuccessDataResult<>(this.service.updateCart(request, cartItemId), "updated book");
    }

}
