package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.dto.CommentPostRequest;
import com.teknokafalar.piabackend.dto.CommentResponse;
import com.teknokafalar.piabackend.entities.Comment;
import com.teknokafalar.piabackend.repository.CommentRepository;
import com.teknokafalar.piabackend.service.abstracts.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> getComment() {
        return this.commentRepository.findAll();
    }

    @Override
    public CommentResponse postComment(CommentPostRequest commentPostRequst) {
        return null;
    }
}
