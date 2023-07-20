package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.dto.request.BookRequest;
import com.teknokafalar.piabackend.dto.response.BookResponse;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.entities.Book;
import com.teknokafalar.piabackend.entities.Type;
import com.teknokafalar.piabackend.repository.AuthorRepository;
import com.teknokafalar.piabackend.repository.BookRepository;
import com.teknokafalar.piabackend.repository.TypeRepository;
import com.teknokafalar.piabackend.service.abstracts.BookService;
import com.teknokafalar.piabackend.util.BookMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final TypeRepository typeRepository;

    private final BookMapperUtil mapperUtil;
    @Override
    public List<Book> getBook() {
        return this.bookRepository.findAll().stream().sorted(Comparator.comparing(Book:: getId)).collect(Collectors.toList());
    }
    public List<Book> getLastBook() {
        return this.bookRepository.findAll()
                .stream().sorted(Comparator.comparing(Book::getAddedDate).reversed()).collect(Collectors.toList());
    }

    @Override
    public BookResponse postBook(BookRequest request) {
        Book book = mapperUtil.toBook(request);
        Book saveBook = bookRepository.save(book);
        return BookMapperUtil.toBookResponse(saveBook);
    }

    @Override
    public BookResponse updateBook(BookRequest request, Long bookId) {
        Optional<Book> bookDb = this.bookRepository.findById(bookId);
        Optional<Author> authorDb = this.authorRepository.findById(request.getAuthorId());
        Author author = authorDb.get();
        Optional<Type> typeDb = this.typeRepository.findById(request.getTypeId());
        Type type =  typeDb.get();
        Book book = null;
        if (bookDb.isPresent()){
            book = bookDb.get();
            book.setPrice(request.getPrice());
            book.setStock(request.getStock());
            book.setName(request.getName());
            book.setYear(request.getYear());
            book.setBookSummary(request.getBookSummary());
            book.setPublisher(request.getPublisher());
            book.setImagesUrl(request.getImagesUrl());
            book.setAuthor(author);
            book.setType(type);

        }
        Book updateBook =bookRepository.save(book);
        return BookMapperUtil.toBookResponse(updateBook);
    }

    @Override
    public BookResponse deleteBook(Long bookId) {
        Optional<Book> bookDb = this.bookRepository.findById(bookId);
        Book book = bookDb.get();
        this.bookRepository.deleteById(bookId);
        return BookMapperUtil.toBookResponse(book);

    }
}
