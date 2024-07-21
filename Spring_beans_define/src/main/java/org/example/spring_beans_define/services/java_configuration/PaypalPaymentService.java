package org.example.spring_beans_define.services.java_configuration;

public class PaypalPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }

    public void init() {
        System.out.println("PaypalPaymentService is initialized.");
    }

    public void destroy() {
        System.out.println("PaypalPaymentService is destroyed.");
    }
}
