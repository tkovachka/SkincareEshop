package org.example.skincareeshop.service.impl;

import org.example.skincareeshop.exceptions.UserNotFoundException;
import org.example.skincareeshop.models.User;
import org.example.skincareeshop.repository.UserRepository;
import org.example.skincareeshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
