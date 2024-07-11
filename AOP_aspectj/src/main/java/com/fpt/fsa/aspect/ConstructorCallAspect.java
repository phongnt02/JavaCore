package com.fpt.fsa.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConstructorCallAspect {

    @Before("execution(com.fpt.fsa.service.UserServiceAOP.new(..))")
    public void logBeforeConstructor() {
        System.out.println("Constructor called...");
    }
}
