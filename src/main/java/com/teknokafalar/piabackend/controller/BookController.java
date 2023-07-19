package com.teknokafalar.piabackend.controller;

import com.teknokafalar.piabackend.core.utilities.results.DataResult;
import com.teknokafalar.piabackend.core.utilities.results.ErrorDataResult;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;
import com.teknokafalar.piabackend.dto.AuthorPostRequest;
import com.teknokafalar.piabackend.dto.BookPostRequest;
import com.teknokafalar.piabackend.dto.BookResponse;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.entities.Book;
import com.teknokafalar.piabackend.service.abstracts.AuthorService;
import com.teknokafalar.piabackend.service.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService service;
    @PostMapping("/save")
    public ResponseEntity<?> postBook(@RequestBody BookPostRequest request) {
            BookResponse bookResponse = this.service.postBook(request);
            System.out.println(request);
            return ResponseEntity.ok().body(new SuccessDataResult<>(bookResponse, "added books"));
    }

    @GetMapping("/list")

    public DataResult<List<Book>> getBook() {
        try {

            return new SuccessDataResult<>(this.service.getBook(), "all of listed author");

        } catch (Exception e) {

            return new ErrorDataResult<>("not listed, return code");
        }

    }
    @PutMapping("/update")
    public Result updateBook(@RequestBody BookPostRequest request,@RequestParam Long bookId) {
        System.out.println(request);
            return new SuccessDataResult<>(this.service.updateBook(request, bookId),"updated book" );
    }
}
