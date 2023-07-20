package com.teknokafalar.piabackend.repository;

import com.teknokafalar.piabackend.entities.Cart;
import com.teknokafalar.piabackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findByUser(User user);

}
