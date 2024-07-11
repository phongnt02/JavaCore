package com.fpt.fsa.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("allMethodsPointcut()")
    public void logBefore() {
        System.out.println("Entering method...");
    }

    @Pointcut("within(com.fpt.fsa.service.*)")
    public void allMethodsPointcut(){}

    /**
     * create* : đại diện cho tất cả phương thức có tên bắt đầu bằng create
     * (..) : chỉ rõ phương thức có thể có 0,1 hoặc nhiều tham số. Nếu không có .. thì
     * chỉ khớp với các phương thức bắt đầu bằng create và có 1 tham số
     */
    @After("execution(* com.fpt.fsa.service.UserServiceAOP.create*(..))")
    public void logAfter() {
        System.out.println("Exiting method...");
    }

}
