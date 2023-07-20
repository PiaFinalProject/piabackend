package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.dto.request.CommentPostRequest;
import com.teknokafalar.piabackend.dto.response.CommentResponse;
import com.teknokafalar.piabackend.entities.Comment;
import com.teknokafalar.piabackend.repository.CommentRepository;
import com.teknokafalar.piabackend.service.abstracts.CommentService;
import com.teknokafalar.piabackend.util.CommentMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    private final CommentMapperUtil mapperUtil;


    @Override

    public List<CommentResponse> getCommentResponses() {
        List<Comment> comments = this.commentRepository.findAll();
        List<CommentResponse> responses = new ArrayList<>();

        for (Comment comment : comments) {
            responses.add(mapperUtil.toCommentResponse(comment));
        }

        return responses;
    }

    @Override
    public CommentResponse postComment(CommentPostRequest commentPostRequest) {
        Comment comment = mapperUtil.toComment(commentPostRequest);
        Comment saveComment = commentRepository.save(comment);

        return CommentMapperUtil.toCommentResponse(saveComment);
    }

    @Override
    public List<CommentResponse> getCommentsByBookId(Long bookId) {
        List<Comment> comments = this.commentRepository.getCommentsByBookId(bookId);
        List<CommentResponse> responses = new ArrayList<>();

        for (Comment comment : comments) {
            responses.add(mapperUtil.toCommentResponse(comment));
        }
        return responses;
    }


}
