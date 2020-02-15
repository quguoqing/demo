package com.example.demo.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: chunmu
 * @Date: 2020/2/14 21:27
 * @Description:
 */
public class MyHelloHandler implements InvocationHandler {

    private IHello instance;

    public MyHelloHandler(IHello instance){
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy.class=" + proxy.getClass().getName());
        return method.invoke(instance, args);
    }
}
