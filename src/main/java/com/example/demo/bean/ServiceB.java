package com.example.demo.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: chunmu
 * @Date: 2019/9/16 20:00
 * @Description:
 */
@Component
public class ServiceB {

    @Autowired
    ServiceA serviceA;

}
