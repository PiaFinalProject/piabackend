package com.teknokafalar.piabackend.repository;

import com.teknokafalar.piabackend.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}

