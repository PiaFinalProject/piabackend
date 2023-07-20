package com.teknokafalar.piabackend.repository;

import com.teknokafalar.piabackend.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> getCommentsByBookId(Long bookId);
}
