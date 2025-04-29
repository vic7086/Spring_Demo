package com.example.spring_demo_spring_batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringDemoSpringBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoSpringBatchApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("批处理作业已完成，应用程序将继续运行...");
            System.out.println("请访问 http://localhost:8080/h2-console 查看数据库");
            System.out.println("数据库连接信息：");
            System.out.println("JDBC URL: jdbc:h2:mem:testdb");
            System.out.println("Username: sa");
            System.out.println("Password: (留空)");
        };
    }
}
