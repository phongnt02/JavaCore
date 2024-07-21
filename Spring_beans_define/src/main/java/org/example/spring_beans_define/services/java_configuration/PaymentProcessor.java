package org.example.spring_beans_define.services.java_configuration;

import org.springframework.beans.factory.annotation.Qualifier;

public class PaymentProcessor {
    private final PaymentService paymentService;

    public PaymentProcessor(@Qualifier("creditCardPaymentService") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void process(double amount) {
        paymentService.processPayment(amount);
    }
}