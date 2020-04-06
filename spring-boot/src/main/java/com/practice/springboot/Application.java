package com.practice.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.practice")
@EnableJpaRepositories(basePackages = "com.practice")
@EntityScan(basePackages = "com.practice")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
