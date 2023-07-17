package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.dto.BookPostRequest;
import com.teknokafalar.piabackend.dto.BookResponse;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.entities.Book;
import com.teknokafalar.piabackend.entities.Type;
import com.teknokafalar.piabackend.repository.AuthorRepository;
import com.teknokafalar.piabackend.repository.BookRepository;
import com.teknokafalar.piabackend.service.abstracts.BookService;
import com.teknokafalar.piabackend.util.AuthorMapperUtil;
import com.teknokafalar.piabackend.util.BookMapperUtil;
import com.teknokafalar.piabackend.util.TypeMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private final BookMapperUtil mapperUtil;

    @Override
    public List<Book> getBook() {
        return this.bookRepository.findAll();
    }
    @Override
    public BookResponse postBook(BookPostRequest request) {
        Book book = mapperUtil.toBook(request);
        Book saveBook = bookRepository.save(book);
        return BookMapperUtil.toBookResponse(saveBook);
    }
    @Override
    public BookResponse updateBook(BookPostRequest request, Long bookId) {

        Optional<Book> bookDb = this.bookRepository.findById(bookId);
        Book book = null;
        if (bookDb.isPresent()) {
            book = bookDb.get();

            // Kitabın var olan bilgilerini güncelle
            book.setName(request.getName());
            book.setYear(request.getYear());
            book.setBookSummary(request.getBookSummary());
            book.setPublisher(request.getPublisher());
            book.setImagesUrl(request.getImagesUrl());

            // Yazarı güncelle
            Optional<Author> authorDb = authorRepository.findById(request.getAuthorId());
            if (authorDb.isPresent()) {
                Author author = authorDb.get();
                book.setAuthor(author);
            }


        }
        Book updatedBook = bookRepository.save(book);

        return BookMapperUtil.toBookResponse(updatedBook);
    }

    @Override
    public BookResponse deleteBook(Long bookId) {
        Optional<Book> bookDb = this.bookRepository.findById(bookId);

        Book book = bookDb.get();

        this.bookRepository.deleteById(bookId);

        return BookMapperUtil.toBookResponse(book);
    }

}
