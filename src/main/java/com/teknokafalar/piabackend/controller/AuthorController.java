package com.teknokafalar.piabackend.controller;

import com.teknokafalar.piabackend.dto.AuthorPostRequest;
import com.teknokafalar.piabackend.dto.AuthorResponse;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.service.abstracts.AuthorService;
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
    public ResponseEntity<?> save(@RequestBody AuthorPostRequest request){

        return new ResponseEntity<>("added", HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<Author>getAuthor(){

        return service.getAuthor();
    }
}
