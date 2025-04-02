package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.User;
import com.example.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Show Registration Page
    @GetMapping("/")
    public String showRegisterPage() {
        return "Register"; // Maps to Register.jsp
    }

    // Process Registration
    @PostMapping("/processRegistration")
    public ModelAndView registerUser(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.registerUser(user);
        return new ModelAndView("redirect:/login");
    }

    // Show Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "Login"; // Maps to Login.jsp
    }

    // Process Login
    @PostMapping("/login")
    public ModelAndView processLogin(@RequestParam String username, 
                                     @RequestParam String password, 
                                     HttpSession session) {
        User user = userService.validateUser(username, password);
        if (user != null) {
            session.setAttribute("loggedInUser", username);
            return new ModelAndView("redirect:/Addexpense");
        } else {
            return new ModelAndView("Login", "error", "Invalid Username or Password");
        }
    }

    // Logout User
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/login");
    }
}
