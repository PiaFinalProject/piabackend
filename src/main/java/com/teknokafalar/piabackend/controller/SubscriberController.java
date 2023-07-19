package com.teknokafalar.piabackend.controller;

import com.teknokafalar.piabackend.core.utilities.results.DataResult;
import com.teknokafalar.piabackend.core.utilities.results.ErrorDataResult;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;
import com.teknokafalar.piabackend.dto.SubscriberPostRequest;
import com.teknokafalar.piabackend.entities.Subscriber;
import com.teknokafalar.piabackend.service.abstracts.SubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriber")
@RequiredArgsConstructor
public class SubscriberController {
    private final SubscriberService service;
    @PostMapping("/save")
    public Result postSubscriber(@RequestBody SubscriberPostRequest request) {
        try {
            return  new SuccessDataResult<>(this.service.postSubscriber(request),"added subscriber");
        }
        catch (Exception e) {
            return new SuccessDataResult<>("not added, return code");
        }
    }
    @GetMapping("/list")
    public DataResult<List<Subscriber>> getSubscriber() {
        try {

            return new SuccessDataResult<>(this.service.getSubscriber(), "all of listed subscriber");

        }
        catch (Exception e) {

            return new ErrorDataResult<>("not listed, return code");
        }
    }
    @PutMapping("/update")
    public Result updateSubscriber(@RequestBody SubscriberPostRequest request, @RequestParam Long subscriberId) {
        try {
            return new SuccessDataResult<>(this.service.updateSubscriber(request, subscriberId),"updated subscriber");
        }
        catch (Exception e) {
            return new SuccessDataResult<>("not updated, return code");
        }
    }
    @DeleteMapping("/delete")
    public Result deleteSubscriber(@RequestParam Long subscriberId) {
        try {
            return new SuccessDataResult<>(this.service.deleteSubscriber(subscriberId), "deleted subscriber");
        }
        catch (Exception e) {
            return new SuccessDataResult<>("not deleted, return code");
        }
    }
}
