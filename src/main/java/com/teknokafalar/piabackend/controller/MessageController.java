package com.teknokafalar.piabackend.controller;

import com.teknokafalar.piabackend.core.utilities.results.DataResult;
import com.teknokafalar.piabackend.core.utilities.results.ErrorDataResult;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;
import com.teknokafalar.piabackend.dto.MessagePostRequest;
import com.teknokafalar.piabackend.entities.Message;
import com.teknokafalar.piabackend.service.abstracts.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService service;
    @PostMapping("/save")
    public Result postMessage(@RequestBody MessagePostRequest request) {
        try {
            return new SuccessDataResult<>(this.service.postMessage(request),"added message");
        }
        catch (Exception e) {
            return new SuccessDataResult<>("not added, return code");
        }
    }
    @GetMapping("/list")
    public DataResult<List<Message>> getMessage() {
        try {
            return new SuccessDataResult<>(this.service.getMessage(), "all of listed message");
        }
        catch (Exception e) {
            return new ErrorDataResult<>("not listed, return code");
        }
    }
    @DeleteMapping("/delete")
    public Result deleteMessage(@RequestParam Long messageId) {
        try {
            return new SuccessDataResult<>(this.service.deleteMessage(messageId), "deleted message");
        }
        catch (Exception e) {
            return new SuccessDataResult<>("not deleted, return code");
        }
    }
}
