package com.spring.springcharacteristic;

import com.spring.springcharacteristic.aop.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@SpringBootApplication
@ComponentScan()
@EnableAspectJAutoProxy
public class SpringCharacteristicApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringCharacteristicApplication.class, args);
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(SpringCharacteristicApplication.class);
        UserService userService = context.getBean(UserService.class);
        String login = userService.login();
    }

}
