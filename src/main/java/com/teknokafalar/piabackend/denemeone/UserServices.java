package com.teknokafalar.piabackend.denemeone;

import java.util.List;

import javax.transaction.Transactional;

import com.teknokafalar.piabackend.entities.User;
import com.teknokafalar.piabackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServices {

    @Autowired
    private UserRepository repo;

    public List<User> listAll() {
        return repo.findAll(Sort.by("email").ascending());
    }

}
