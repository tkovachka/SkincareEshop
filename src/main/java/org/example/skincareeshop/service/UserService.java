package org.example.skincareeshop.service;

import org.example.skincareeshop.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
}
