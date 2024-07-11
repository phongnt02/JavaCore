package com.fpt.fsa.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceAOP {
    private String username;

    public void createUser(String username) {
        this.username = username;
        // Business logic
        System.out.println("User " + username + " created.");
    }

    public void deleteUser(String username) {
        // Business logic
        System.out.println("User " + username + " deleted.");
    }

    public void throwException() throws Exception {
        throw new Exception("Sample Exception");
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
