package com.teknokafalar.piabackend.controller;

import com.teknokafalar.piabackend.core.utilities.results.DataResult;
import com.teknokafalar.piabackend.core.utilities.results.ErrorDataResult;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;

import com.teknokafalar.piabackend.dto.AuthorPostRequest;
import com.teknokafalar.piabackend.dto.AuthorResponse;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.service.abstracts.AuthorService;
import com.teknokafalar.piabackend.util.AuthorMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService service;
    @PostMapping("/save")
    public Result postAuthor(@RequestBody AuthorPostRequest request) {
        try {
            return new SuccessDataResult<>(this.service.postAuthor(request),"added author" );
        }
        catch (Exception e) {
            e.getMessage();
            return new SuccessDataResult<>("not added, return code");
        }
    }
    @GetMapping("/list")
    public DataResult<List<Author>> getAuthor() {

        try {
            System.out.println("deneme");
            return new SuccessDataResult<>(this.service.getAuthor(), "all of listed author");
        } catch (Exception e) {
            return new ErrorDataResult<>("not listed, return code");
        }

    }

}
