package com.teknokafalar.piabackend.repository;

import com.teknokafalar.piabackend.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
