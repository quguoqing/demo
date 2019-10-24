package com.example.demo.bean;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * @author: chunmu
 * @Date: 2019/10/21 10:50
 * @Description:
 */
@Service
public class MyDemoApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        //这里没有明确指定，监听具体event事件。那么会监听所有事件。
        System.out.println("MyDemoApplicationListener process, event=" + event.toString());
    }
}
