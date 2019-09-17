package com.example.demo.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author: chunmu
 * @Date: 2019/9/17 21:06
 * @Description:
 */
public class TicketServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("BEFORE_ADVICE: 欢迎光临代售点...., method=" + method.getName());
    }
}
