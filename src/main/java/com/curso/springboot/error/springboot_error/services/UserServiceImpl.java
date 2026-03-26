package com.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.springboot.error.springboot_error.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private List<User> users;


    @Override
    public List<User> findAll() {
        return users;

    }

    @Override
    public Optional<User> findById(Long id) {
        return findAll().stream()
            .filter(user -> user.getId().equals(id))
            .findFirst()
            //.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id))
            ;
    }

}
