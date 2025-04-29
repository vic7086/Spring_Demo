package com.example.spring_demo_spring_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.spring_demo_spring_aop.service.CalculatorService.*(..))")
    public void calculatorMethods() {}

    @Around("calculatorMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        
        System.out.println("\n=== Method Execution Details ===");
        System.out.println("Method: " + methodName);
        System.out.println("Parameters: " + java.util.Arrays.toString(args));
        
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        
        System.out.println("Execution Time: " + (endTime - startTime) + "ms");
        System.out.println("Return Value: " + result);
        System.out.println("=== End of Method Execution ===\n");
        
        return result;
    }
} 