package com.teknokafalar.piabackend.repository;

import com.teknokafalar.piabackend.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
