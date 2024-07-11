package com.fpt.fsa.service;

/**
 * Vấn đề
 * Logging logic bị lặp lại trong từng phương thức.
 * Mã nguồn trở nên khó đọc và bảo trì.
 */
public class UserServiceNormal {
    public void createUser(String username) {
        // Logging logic
        System.out.println("Entering createUser method with username: " + username);

        // Business logic
        System.out.println("User " + username + " created.");

        // Logging logic
        System.out.println("Exiting createUser method with username: " + username);
    }

    public void deleteUser(String username) {
        // Logging logic
        System.out.println("Entering deleteUser method with username: " + username);

        // Business logic
        System.out.println("User " + username + " deleted.");

        // Logging logic
        System.out.println("Exiting deleteUser method with username: " + username);
    }

}
