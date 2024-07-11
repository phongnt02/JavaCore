package com.fpt.fsa.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

/**
 * Aspect cho logging trước và sau khi một phương thức được gọi
 */
@Aspect
@Component
public class MethodExecutionAspect {
    @Before("execution(* com.fpt.fsa.service.UserServiceAOP.*(..))")
    public void logBeforeMethod() {
        System.out.println("JOIN POINT Entering method...");
    }

    @After("execution(* com.fpt.fsa.service.UserServiceAOP.*(..))")
    public void logAfterMethod() {
        System.out.println("JOIN POINT Exiting method...");
    }
}
