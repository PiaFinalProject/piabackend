package com.teknokafalar.piabackend.repository;

import com.teknokafalar.piabackend.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
