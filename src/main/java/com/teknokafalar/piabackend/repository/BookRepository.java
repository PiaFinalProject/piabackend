package com.teknokafalar.piabackend.repository;

import com.teknokafalar.piabackend.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
