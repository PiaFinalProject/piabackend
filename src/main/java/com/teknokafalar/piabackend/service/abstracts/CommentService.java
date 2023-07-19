package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.dto.AuthorPostRequest;
import com.teknokafalar.piabackend.dto.AuthorResponse;
import com.teknokafalar.piabackend.dto.CommentPostRequest;
import com.teknokafalar.piabackend.dto.CommentPostRequst;
import com.teknokafalar.piabackend.dto.CommentResponse;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.entities.Comment;
import org.springframework.boot.web.server.Cookie;

import java.util.List;

public interface CommentService {

    List<Comment> getComment();

    CommentResponse postComment(CommentPostRequest comment);

}
