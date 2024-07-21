package org.example.spring_beans_define.services.anotation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {
    private final PaymentService paymentService;

    @Autowired
    public PaymentProcessor(@Qualifier("creditCardPaymentService") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void process(double amount) {
        paymentService.processPayment(amount);
    }

    public void init() {
        System.out.println("PaymentProcessor Annotation initialized.");
    }

    public void destroy() {
        System.out.println("PaymentProcessor Annotation destroyed.");
    }
}