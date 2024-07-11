package com.fpt.fsa.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void placeOrder(String orderId) {
        // Business logic
        System.out.println("Order " + orderId + " placed.");
    }

    public void cancelOrder(String orderId) {
        // Business logic
        System.out.println("Order " + orderId + " cancelled.");
    }

    public void updateOrder(String orderId) {
        // Business logic
        System.out.println("Order " + orderId + " updated.");
    }
}
