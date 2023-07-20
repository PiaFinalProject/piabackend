package com.teknokafalar.piabackend.util;

import com.teknokafalar.piabackend.dto.AuthorPostRequest;
import com.teknokafalar.piabackend.dto.AuthorResponse;
import com.teknokafalar.piabackend.dto.BookPostRequest;
import com.teknokafalar.piabackend.dto.BookResponse;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.entities.Book;
import com.teknokafalar.piabackend.entities.Type;
import com.teknokafalar.piabackend.repository.AuthorRepository;
import com.teknokafalar.piabackend.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;


@RequiredArgsConstructor
@Component
public class BookMapperUtil {
    private final  AuthorRepository authorRepository;
    private final TypeRepository typeRepository;

    public Book toBook(BookPostRequest request) {
        Author authorOptional = authorRepository.findById(request.getAuthorId()).get();
        Type typeOptional = typeRepository.findById(request.getTypeId()).get();


        Author author = authorOptional;
        Type type = typeOptional;

        Book book = new Book();
        book.setName(request.getName());
        book.setYear(request.getYear());
        book.setBookSummary(request.getBookSummary());
        book.setPublisher(request.getPublisher());
        book.setImagesUrl(request.getImagesUrl());
        book.setAuthor(author);
        book.setType(type);
        book.setAddedDate(LocalDateTime.now());

        return book;
    }

    public static BookResponse toBookResponse(Book book) {
        BookResponse response = new BookResponse();

        response.setName(book.getName());
        response.setYear(book.getYear());
        response.setBookSummary(book.getBookSummary());
        response.setPublisher(book.getPublisher());
        response.setImagesUrl(book.getImagesUrl());

        response.setAuthorId(book.getAuthor().getId()); // Doğru şekilde atama yapılıyor
        response.setTypeId(book.getType().getId()); // Doğru şekilde atama yapılıyor

        return response;
    }


}
