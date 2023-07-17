package com.teknokafalar.piabackend.controller;

import com.teknokafalar.piabackend.core.utilities.results.DataResult;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;
import com.teknokafalar.piabackend.dto.CommentPostRequest;
import com.teknokafalar.piabackend.dto.CommentPostRequst;
import com.teknokafalar.piabackend.entities.Comment;
import com.teknokafalar.piabackend.service.abstracts.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/list")

    public DataResult<List<Comment>> getAuthor() {

            return new SuccessDataResult<>(this.commentService.getComment(), "all of listed author");

    }

    @PostMapping("/save")
    public Result postComment(@RequestBody CommentPostRequest comment) {
            return new SuccessDataResult<>(this.commentService.postComment(comment),"added author" );
    }
}
