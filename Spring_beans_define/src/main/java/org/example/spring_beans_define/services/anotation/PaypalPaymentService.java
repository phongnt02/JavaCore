package org.example.spring_beans_define.services.anotation;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class PaypalPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }

    @PostConstruct
    public void init() {
        System.out.println("PaypalPaymentService is initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PaypalPaymentService is destroyed.");
    }
}
