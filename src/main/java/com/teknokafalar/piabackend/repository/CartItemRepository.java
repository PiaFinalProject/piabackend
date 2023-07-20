package com.teknokafalar.piabackend.repository;

import com.teknokafalar.piabackend.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
