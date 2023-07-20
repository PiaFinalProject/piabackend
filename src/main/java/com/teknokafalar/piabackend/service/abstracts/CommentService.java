package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.dto.request.CommentPostRequest;
import com.teknokafalar.piabackend.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {

    List<CommentResponse> getCommentResponses();

    CommentResponse postComment(CommentPostRequest comment);

    List<CommentResponse> getCommentsByBookId(Long bookId);

}
