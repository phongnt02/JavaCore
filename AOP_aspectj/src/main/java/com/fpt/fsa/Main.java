package com.fpt.fsa;

import com.fpt.fsa.service.OrderService;
import com.fpt.fsa.service.UserServiceAOP;
import com.fpt.fsa.service.UserServiceNormal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

@SpringBootApplication
@EnableAspectJAutoProxy
public class Main implements CommandLineRunner {
    @Autowired
    private UserServiceAOP userServiceAOP;

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
//        withoutAOP();
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("====================== WITH AOP ======================");
        userServiceAOP.createUser("john_doe");
        userServiceAOP.deleteUser("john_doe");
//        userServiceAOP.throwException();

        orderService.placeOrder("order123");
        orderService.updateOrder("order123");
        orderService.cancelOrder("order123");
    }

    private static void withoutAOP() {
        System.out.println("====================== WITHOUT AOP ======================");
        UserServiceNormal userService = new UserServiceNormal();
        userService.createUser("john_doe");
        userService.deleteUser("john_doe");
    }
}
