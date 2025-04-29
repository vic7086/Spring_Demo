package com.example.spring_demo_core_container;
import com.example.spring_demo_core_container.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Qualifier;

// 这是Spring Boot的主启动类
@SpringBootApplication
public class SpringDemoCoreContainerApplication {

    public static void main(String[] args) {
        // 启动Spring Boot应用，返回Spring的应用上下文（容器）
        ApplicationContext context = SpringApplication.run(SpringDemoCoreContainerApplication.class, args);

        // 从容器中获取名为"simpleMessageService"的Bean，类型为MessageService
        MessageService messageService = context.getBean("simpleMessageService", MessageService.class);
        // 调用getMessage方法，输出消息
        System.out.println("Message from container: " + messageService.getMessage());

        // 再次从容器中获取同一个Bean，演示单例模式
        MessageService anotherService = context.getBean("simpleMessageService", MessageService.class);
        // 判断两次获取的Bean是否是同一个实例（单例）
        System.out.println("Are both services the same instance? " + (messageService == anotherService));
    }
}
