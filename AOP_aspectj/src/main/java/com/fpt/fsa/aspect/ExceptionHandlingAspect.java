package com.fpt.fsa.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

    @AfterThrowing(pointcut = "execution(* com.fpt.fsa.service.UserServiceAOP.*(..))", throwing = "ex")
    public void logException(Exception ex) {
        System.out.println("Exception thrown: " + ex.getMessage());
    }
}
