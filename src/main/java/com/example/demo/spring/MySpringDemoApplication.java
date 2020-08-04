package com.example.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: chunmu
 * @Date: 2020/6/19 16:27
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "com.example.demo.spring")
public class MySpringDemoApplication {

    public static void main(String[] args){
        SpringApplication.run(MySpringDemoApplication.class, args);
    }

}
