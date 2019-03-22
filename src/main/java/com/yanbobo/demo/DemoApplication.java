package com.yanbobo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 是spring-boot的核心注解，是一个组合注解，包含了：@Configuration、@EnableAutoConfiguration、@ComponentScan
 */
@SpringBootApplication
/*@Configuration
@EnableAutoConfiguration
@ComponentScan*/
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
