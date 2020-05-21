package com.example.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: chunmu
 * @Date: 2020/5/19 23:06
 * @Description:
 */
public class DemoSpringApplication {

    public static void main(String[] args){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("a"));
        // System.out.println(context.getBean("userMapper"));
        System.out.println(context.getBean("CFactory"));
    }

}
