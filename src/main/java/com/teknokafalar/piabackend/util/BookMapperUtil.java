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

    public Book toBook(BookPostRequest bookRequest) {
        Author authorOptional = authorRepository.findById(request.getAuthorId()).get();
        Type typeOptional = typeRepository.findById(request.getTypeId()).get();


        Author author = authorOptional;
        Type type = typeOptional;

        Book book = new Book();
        book.setPrice(bookRequest.getPrice());
        book.setStock(bookRequest.getStock());
        book.setName(bookRequest.getName());
        book.setBookSummary(bookRequest.getBookSummary());
        book.setPublisher(bookRequest.getPublisher());
        book.setImagesUrl(bookRequest.getImagesUrl());
        Optional<Author> authorOptional = authorRepository.findById(bookRequest.getAuthorId());
        if (authorOptional.isPresent()) {
            book.setAuthor(authorOptional.get());
        }
        Optional<Type> typeOptional = typeRepository.findById(bookRequest.getTypeId());
        if (typeOptional.isPresent()) {
            book.setType(typeOptional.get());
        }
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
