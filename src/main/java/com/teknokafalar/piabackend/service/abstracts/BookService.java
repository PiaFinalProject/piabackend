package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.dto.request.BookRequest;
import com.teknokafalar.piabackend.dto.response.BookResponse;
import com.teknokafalar.piabackend.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getBook();
    List<Book>getLastBook();
    BookResponse postBook(BookRequest request);
    BookResponse updateBook(BookRequest request, Long bookId);
    BookResponse deleteBook(Long bookId) ;

}
