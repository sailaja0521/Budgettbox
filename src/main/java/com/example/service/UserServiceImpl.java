package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.respository.UserRespository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRespository userRespository;

    @Override
    public User registerUser(User user) {
        return userRespository.save(user);
    }

    @Override
    public User updateuser(User user) {
        return userRespository.save(user);
    }

    @Override
    public void deleteUser(long id) {
    	
        userRespository.deleteById(id);
    }

    @Override
    public User findById(long id) {
        return userRespository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRespository.findAll();
    }

    // Validate user credentials
    @Override
    public User validateUser(String username, String password) {
        Optional<User> user = userRespository.findByUsernameAndPassword(username, password);
        return user.orElse(null);
    }
    @Override
    public User findByUsername(String username) {
        return userRespository.findByUsername(username);
    }
    @Override
    public User updateUser(Long id, User user) {
        User users = userRespository.findById(id).orElse(null);
        if (users != null) {
            users.setUsername(user.getUsername());
            users.setPassword(user.getPassword());
            return userRespository.save(user);
        }
        return null;
    }
}
