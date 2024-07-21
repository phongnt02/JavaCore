package org.example.spring_beans_define.configs;

import org.example.spring_beans_define.services.java_configuration.CreditCardPaymentService;
import org.example.spring_beans_define.services.java_configuration.PaymentProcessor;
import org.example.spring_beans_define.services.java_configuration.PaymentService;
import org.example.spring_beans_define.services.java_configuration.PaypalPaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfigJava {

    @Bean
    public PaymentProcessor paymentProcessor(PaymentService creditCardPaymentService) {
        return new PaymentProcessor(creditCardPaymentService);
    }

    @Bean
    public PaymentService creditCardPaymentService() {
        return new CreditCardPaymentService();
    }

    @Primary
    @Bean
    public PaymentService paypalPaymentService() {
        return new PaypalPaymentService();
    }
}
