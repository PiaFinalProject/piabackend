package com.teknokafalar.piabackend.service.concrete;
import com.teknokafalar.piabackend.dto.request.AuthorPostRequest;
import com.teknokafalar.piabackend.dto.response.AuthorResponse;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.repository.AuthorRepository;
import com.teknokafalar.piabackend.service.abstracts.AuthorService;
import com.teknokafalar.piabackend.util.AuthorMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;

    @Override
    public AuthorResponse postAuthor(AuthorPostRequest request) {
        Author author = AuthorMapperUtil.toAuthor(request);
        Author saveAuthor = repository.save(author);

        return AuthorMapperUtil.toAuthorResponse(saveAuthor);
    }


    @Override
    public List<Author> getAuthor() {
        return repository.findAll();
    }

    @Override
    public Author getAuthorById(Long authorId) {
        return repository.findById(authorId).get();
    }

    @Override
    public AuthorResponse updateAuthor(AuthorPostRequest request, Long authorId) {
        Optional<Author> authorDb = this.repository.findById(authorId);

        Author author = authorDb.get();

        if (authorDb.isPresent()) {
            author.setAbout(request.getAbout());
            author.setLastName(request.getLastName());
            //author.setBirthday(request.getBirthday());
            author.setFirstName(request.getFirstName());
        }
        repository.save(author);
        return AuthorMapperUtil.toAuthorResponse(author);
    }

    public AuthorResponse deleteAuthor(Long authorId) {
        Optional<Author> authorDb = this.repository.findById(authorId);

        Author author = authorDb.get();

       this.repository.deleteById(authorId);

        return AuthorMapperUtil.toAuthorResponse(author);
    }
}
