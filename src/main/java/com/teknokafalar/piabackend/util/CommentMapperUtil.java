package com.teknokafalar.piabackend.util;

import com.teknokafalar.piabackend.dto.request.CommentPostRequest;
import com.teknokafalar.piabackend.dto.response.CommentResponse;
import com.teknokafalar.piabackend.entities.Comment;
import com.teknokafalar.piabackend.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentMapperUtil {
    private final CommentRepository commentRepository;

    public Comment toComment(CommentPostRequest request) {
        Comment comment = new Comment();

        comment.setFirstName(request.getFirstName());
        comment.setLastName(request.getLastName());
        comment.setText(request.getText());
        comment.setEmail(request.getEmail());;
        return comment;

    }

    public static CommentResponse toCommentResponse(Comment comment) {
        CommentResponse response = new CommentResponse();

        response.setFirstName(comment.getFirstName());
        response.setLastName(comment.getLastName());
        response.setText(comment.getText());
        response.setEmail(comment.getEmail());
        return response;
    }

}
