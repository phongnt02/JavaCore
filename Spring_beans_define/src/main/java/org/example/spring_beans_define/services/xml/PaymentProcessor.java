package org.example.spring_beans_define.services.xml;

public class PaymentProcessor {
    private final PaymentService paymentService;

    public PaymentProcessor(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void process(double amount) {
        paymentService.processPayment(amount);
    }
}