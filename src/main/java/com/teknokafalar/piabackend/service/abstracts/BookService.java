package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.dto.BookPostRequest;
import com.teknokafalar.piabackend.dto.BookResponse;
import com.teknokafalar.piabackend.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getBook();
    BookResponse postBook(BookPostRequest request);
    BookResponse updateBook(BookPostRequest request, Long bookId);
    BookResponse deleteBook(Long bookId) ;
}
