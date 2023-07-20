package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.dto.CommentPostRequest;
import com.teknokafalar.piabackend.dto.CommentResponse;
import com.teknokafalar.piabackend.entities.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComment();

    CommentResponse postComment(CommentPostRequest comment);

    List<CommentResponse> getCommentsByBookId(Long bookId);

}
