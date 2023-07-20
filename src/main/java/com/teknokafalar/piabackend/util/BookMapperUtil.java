package com.teknokafalar.piabackend.util;

import com.teknokafalar.piabackend.dto.request.BookRequest;
import com.teknokafalar.piabackend.dto.response.BookResponse;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.entities.Book;
import com.teknokafalar.piabackend.entities.Type;
import com.teknokafalar.piabackend.repository.AuthorRepository;
import com.teknokafalar.piabackend.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class BookMapperUtil {
    private final AuthorRepository authorRepository;

    private final TypeRepository typeRepository;

    public Book toBook(BookRequest bookRequest){

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
        response.setPrice(book.getPrice());
        response.setStock(book.getStock());
        response.setAuthorId(book.getAuthor().getId());
        response.setTypeId(book.getAuthor().getId());
        return  response;
    }

}
