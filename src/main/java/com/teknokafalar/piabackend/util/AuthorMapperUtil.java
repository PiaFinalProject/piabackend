package com.teknokafalar.piabackend.util;

import com.teknokafalar.piabackend.dto.AuthorPostRequest;
import com.teknokafalar.piabackend.dto.AuthorResponse;
import com.teknokafalar.piabackend.entities.Author;

public class AuthorMapperUtil {
    public static Author toAuthor(AuthorPostRequest request) {
        Author author = new Author();
        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());
        author.setBirthday(request.getBirthday());
        author.setAbout(request.getAbout());

        return author;
    }

    public static AuthorResponse toAuthorResponse(Author author) {
        AuthorResponse response = new AuthorResponse();

        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());
        response.setBirthday(author.getBirthday());
        response.setAbout(author.getAbout());

        return response;
    }
}
