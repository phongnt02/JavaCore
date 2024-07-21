package org.example.spring_beans_define.services.xml;

public class CreditCardPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }

    public void init() {
        System.out.println("CreditCardPaymentService is initialized.");
    }

    public void destroy() {
        System.out.println("CreditCardPaymentService is destroyed.");
    }
}