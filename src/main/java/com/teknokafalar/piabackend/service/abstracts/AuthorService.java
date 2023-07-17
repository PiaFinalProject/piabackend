package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.dto.AuthorPostRequest;
import com.teknokafalar.piabackend.dto.AuthorResponse;
import com.teknokafalar.piabackend.entities.Author;

import java.util.List;

public interface AuthorService {
   AuthorResponse postAuthor(AuthorPostRequest request);
   List<Author>getAuthor();
   AuthorResponse updateAuthor(AuthorPostRequest request, Long authorId);
   AuthorResponse deleteAuthor(Long authorId) ;

}
