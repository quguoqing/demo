package com.example.demo.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * @author: chunmu
 * @Date: 2019/9/17 21:07
 * @Description:
 */
public class TicketServiceAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1)
            throws Throwable {
        System.out.println("AFTER_RETURNING：本次服务已结束...., method=" + method.getName());
    }
}
