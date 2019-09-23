package com.example.demo;

import java.util.Date;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ImportResource(locations={"classpath*:spring/*.xml"})
public class DemoApplication {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(DemoApplication.class, args);
    }
}
