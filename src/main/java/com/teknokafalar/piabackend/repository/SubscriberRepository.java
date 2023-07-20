package com.teknokafalar.piabackend.repository;

import com.teknokafalar.piabackend.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}
