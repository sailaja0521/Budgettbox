package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService {
    User  registerUser(User user);    // Method to register a new user
    User updateuser(User user);
    void deleteUser(long id);
    User findById(long id);
    List<User>findAll();
    public User validateUser(String username, String password);
    User findByUsername(String username);
    public User updateUser(Long id, User userDetails);
}