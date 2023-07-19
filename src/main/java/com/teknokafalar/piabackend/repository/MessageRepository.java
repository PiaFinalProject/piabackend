package com.teknokafalar.piabackend.repository;

import com.teknokafalar.piabackend.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
