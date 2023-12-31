package com.teknokafalar.piabackend.controller;

import com.teknokafalar.piabackend.core.utilities.results.DataResult;
import com.teknokafalar.piabackend.core.utilities.results.ErrorDataResult;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;
import com.teknokafalar.piabackend.dto.request.AuthorPostRequest;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.service.abstracts.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
@CrossOrigin("*")
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

            return new SuccessDataResult<>(this.service.getAuthor(), "all of listed author");

        } catch (Exception e) {

            return new ErrorDataResult<>("not listed, return code");
        }

    }
    @PutMapping("/update")
    public Result updateAuthor(@RequestBody AuthorPostRequest request,@RequestParam Long authorId) {
        try {
            return new SuccessDataResult<>(this.service.updateAuthor(request, authorId),"updated author" );
        }
        catch (Exception e) {
            return new SuccessDataResult<>("not updated, return code");
        }
    }
    @DeleteMapping("/delete")
    public Result deleteAuthor(@RequestParam Long authorId) {
        try {
            return new SuccessDataResult<>(this.service.deleteAuthor(authorId),"deleted author" );
        }
        catch (Exception e) {
            return new SuccessDataResult<>("not deleted, return code");
        }
    }
}
