package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.dto.request.AuthorPostRequest;
import com.teknokafalar.piabackend.dto.response.AuthorResponse;
import com.teknokafalar.piabackend.entities.Author;

import java.util.List;

public interface AuthorService {
   AuthorResponse postAuthor(AuthorPostRequest request);
   List<Author>getAuthor();

   Author getAuthorById(Long authorId);
   AuthorResponse updateAuthor(AuthorPostRequest request, Long authorId);
   AuthorResponse deleteAuthor(Long authorId) ;

}
