package com.teknokafalar.piabackend.service.concrete;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;
import com.teknokafalar.piabackend.dto.AuthorPostRequest;
import com.teknokafalar.piabackend.dto.AuthorResponse;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.repository.AuthorRepository;
import com.teknokafalar.piabackend.service.abstracts.AuthorService;
import com.teknokafalar.piabackend.util.AuthorMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
=======

        return AuthorMapperUtil.toAuthorResponse(saveAuthor);
    }

    @Override
    public List<Author> getAuthor() {
        return repository.findAll();
    }
}
