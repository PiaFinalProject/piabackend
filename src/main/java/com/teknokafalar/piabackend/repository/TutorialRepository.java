package com.teknokafalar.piabackend.repository;

import com.teknokafalar.piabackend.entities.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
