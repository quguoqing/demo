package com.example.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * @author: chunmu
 * @Date: 2019/9/21 16:44
 * @Description:
 */
// @Service
public class MyDemoBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println(
                "bean=" + bean.getClass().getName() + " postProcessBeforeInitialization....");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println(
                "bean=" + bean.getClass().getName() + " postProcessAfterInitialization....");
        return bean;
    }
}
