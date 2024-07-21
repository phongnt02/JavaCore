package org.example.spring_beans_define.services.anotation;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class CreditCardPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }

    @PostConstruct
    public void init() {
        System.out.println("CreditCardPaymentService is initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("CreditCardPaymentService is destroyed.");
    }
}