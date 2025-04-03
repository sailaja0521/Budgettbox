package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	

	
	    @Autowired
	    private UserService userService;

	    @GetMapping("/User/")
	    public List<User> getAllUsers() {
	        return userService.findAll();
	    }

	    @GetMapping("/User/{id}")
	    public User getUserById(@PathVariable Long id) {
	        return userService.findById(id);
	    }

	    @PostMapping("/User/")
	    public User createUser(@RequestBody User user) {
	        return userService.registerUser(user);
	    }

	    @PutMapping("/User/{id}")
	    public User updateUser(@PathVariable Long id, @RequestBody User user) {
	        return userService.updateUser(id, user);
	    }

	    @DeleteMapping("/User/{id}")
	    public void deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	    }
	}
