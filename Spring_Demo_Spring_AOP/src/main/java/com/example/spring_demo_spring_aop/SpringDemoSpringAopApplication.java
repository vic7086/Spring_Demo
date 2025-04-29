package com.example.spring_demo_spring_aop;

import com.example.spring_demo_spring_aop.service.CalculatorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoSpringAopApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDemoSpringAopApplication.class, args);
        CalculatorService calculator = context.getBean(CalculatorService.class);

        // Test calculator methods
        System.out.println("\n=== Testing Addition ===");
        calculator.add(5, 3);

        System.out.println("\n=== Testing Subtraction ===");
        calculator.subtract(10, 4);

        System.out.println("\n=== Testing Multiplication ===");
        calculator.multiply(6, 7);

        System.out.println("\n=== Testing Division ===");
        calculator.divide(20, 4);

        // Test exception case
        System.out.println("\n=== Testing Division by Zero ===");
        try {
            calculator.divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

}
