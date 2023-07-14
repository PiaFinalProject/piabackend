package com.teknokafalar.piabackend.repository;

import com.teknokafalar.piabackend.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}
