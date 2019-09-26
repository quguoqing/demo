package com.example.demo;

import java.util.Date;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.example.demo.bean.ServiceA;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
// @EnableAutoConfiguration
@EnableDubbo
@ImportResource(locations={"classpath*:spring/*.xml"})
public class DemoApplication {

    public static void main(String[] args) throws Throwable{
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        System.out.println("main thread=" + Thread.currentThread().getName());
        new DemoApplication().myStart(context);
        System.out.println("main thread start end");
    }

    private void myStart(ConfigurableApplicationContext context){
        Thread thread = new Thread(new MyRunnable(context));
        System.out.println("WhileTrueTask start....");
        thread.start();
    }


    class MyRunnable implements Runnable{
        ConfigurableApplicationContext context;

        MyRunnable(ConfigurableApplicationContext context){
            this.context = context;
        }

        @Override
        public void run() {
            Thread th = Thread.currentThread();
            while (true){
                try{
                    System.out.println("MyRunnable thread=" + th.getName());
                    Thread.sleep(1000L);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
