package com.teknokafalar.piabackend.controller;

import com.teknokafalar.piabackend.core.utilities.results.DataResult;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;
import com.teknokafalar.piabackend.dto.request.BookRequest;
import com.teknokafalar.piabackend.entities.Book;
import com.teknokafalar.piabackend.service.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {
    private final BookService service;
    @PostMapping("/save")
    public Result postBook(@RequestBody BookRequest request) {
        return new SuccessDataResult<>(this.service.postBook(request),"added books" );
    }
    @GetMapping("/list")

    public DataResult<List<Book>> getBook() {
        return new SuccessDataResult<>(this.service.getBook(), "all of listed books");

        /*ry {


        } catch (Exception e) {

            return new ErrorDataResult<>("not listed, return code");
        }*/

    }

    @PutMapping("/update")
    public Result updateBook(@RequestBody BookRequest request, @RequestParam Long bookId) {
        System.out.println(request);
        return new SuccessDataResult<>(this.service.updateBook(request, bookId), "updated book");
    }



}
