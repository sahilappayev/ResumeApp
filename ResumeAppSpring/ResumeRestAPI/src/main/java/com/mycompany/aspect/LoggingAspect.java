package com.mycompany.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Aspect
@Configuration
public class LoggingAspect {

    @Before("execution(* com.mycompany.service.inter.UserServiceInter.getAll(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("logBefore() is running");
        System.out.println("hijacked: " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @After("execution(* com.mycompany.service.inter.UserServiceInter.getAll(..))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("logAfter() is running");
        System.out.println("hijacked: " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @AfterReturning(pointcut = "execution(* com.mycompany.service.inter.UserServiceInter.getAll(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("logAfterReturning() is running");
        System.out.println("hijacked: " + joinPoint.getSignature().getName());
        System.out.println("Method returned value: " + result);
        System.out.println("******");
    }

    @AfterThrowing(pointcut = "execution(* com.mycompany.service.inter.UserServiceInter.getAll(..))",
    throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error){
        System.out.println("logAfterThrowing() is running");
        System.out.println("hijacked " + joinPoint.getSignature().getName());
        System.out.println("Exception :" + error);
        System.out.println("******");
    }

    @Around("execution(* com.mycompany.service.inter.UserServiceInter.getAll(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("logAround() is running");
        System.out.println("hijacked methods " + joinPoint.getSignature().getName());
        System.out.println("hijacked arguments" + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Arund before is running");
        Object result = joinPoint.proceed();
        System.out.println("Arund after is running");

        System.out.println("******");
        return result;
    }

}
