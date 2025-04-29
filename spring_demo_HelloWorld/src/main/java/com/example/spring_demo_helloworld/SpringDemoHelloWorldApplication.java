package com.example.spring_demo_helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringDemoHelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDemoHelloWorldApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring";
    }

}
