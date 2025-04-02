package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private long id;  // Unique identifier for the user
	    
	    @Column(name = "username", nullable = false, unique = true)
	    private String username;  // Username for login
	    
	    @Column(name = "password", nullable = false)
	    private String password;  // Password for the user
	    
	   

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    @Override
	    public String toString() {
	        return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	    }
	}


