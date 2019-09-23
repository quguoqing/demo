package com.example.demo.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: chunmu
 * @Date: 2019/9/16 20:00
 * @Description:
 */
@Component
// @Transactional
public class ServiceA {

    @Autowired
    private ServiceB serviceB;

    public void hello(){
        System.out.print("hello world");
    }

}
