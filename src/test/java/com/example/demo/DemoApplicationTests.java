package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.dubbo.common.bytecode.Proxy;
import com.alibaba.dubbo.common.bytecode.Wrapper;
import com.example.demo.bean.MyDemoInterface;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void test_getWrapper() {
        Class c = MyDemoInterface.class;
        /**
         * wrapper本身一个抽象类，只有通过getWrapper方法来生成一个wrapper的实现类。
         * 主要是通过javassist，动态生成指定接口C的实现类。这里生成的wrapper是实现了MyDemoInterface的实现类。
         * 其实用javassist生成的类，只是继承了抽象类Wrapper，重写了invokeMethod等几个方法。
         *
         * MyDemoInterface通过getWrapper方法，重新了invokeMethod代码如下：
         * 1、方法名
         * 2、方法参数的个数
         * 3、方法参数的类型
         * 唯一决定一个if分支。w是传进来的ref，业务实现类。
         * public Object invokeMethod(Object o, String n, Class[] p, Object[] v)
         *             throws java.lang.reflect.InvocationTargetException {
         *         com.example.demo.bean.MyDemoInterface w;
         *         try {
         *             w = ((com.example.demo.bean.MyDemoInterface) $1);
         *         } catch (Throwable e) {
         *             throw new IllegalArgumentException(e);
         *         }
         *         try {
         *             if ("sayHello".equals($2) && $3.length == 1 && $3[0].getName()
         *                     .equals("java.lang.String")) {
         *                 w.sayHello((java.lang.String) $4[0]);
         *                 return null;
         *             }
         *             if ("sayHello".equals($2) && $3.length == 2 && $3[0].getName()
         *                     .equals("java.lang.String") && $3[1].getName().equals("java.lang
         *                     .Integer")) {
         *                 w.sayHello((java.lang.String) $4[0], (java.lang.Integer) $4[1]);
         *                 return null;
         *             }
         *             if ("sayHello".equals($2) && $3.length == 2 && $3[0].getName()
         *                     .equals("java.lang.String") && $3[1].getName().equals("java.lang
         *                     .String")) {
         *                 w.sayHello((java.lang.String) $4[0], (java.lang.String) $4[1]);
         *                 return null;
         *             }
         *         } catch (Throwable e) {
         *             throw new java.lang.reflect.InvocationTargetException(e);
         *         }
         *         throw new com.alibaba.dubbo.common.bytecode.NoSuchMethodException(
         *                 "Not found method \"" + $2 + "\" in class com.example.demo.bean
         *                 .MyDemoInterface.");
         *     }
         */
        Wrapper wrapper = Wrapper.getWrapper(c);
        System.out.println(wrapper.toString());
    }

    @Test
    public void test_getProxy(){
        /**
         * Proxy的唯一需要实现的方法newInstance方法。getProxy通过javassist得到的实现类，给实现方法如下：
         * public Object newInstance(java.lang.reflect.InvocationHandler h) {
         *         return new com.alibaba.dubbo.common.bytecode.proxy0($1);
         *     }
         * 而com.alibaba.dubbo.common.bytecode.proxy0这个类，也是getProxy生成的。生成的代理类，就是传入的接口代理实现类。因为接口无法实例化。
         * proxy0完成接口的实现如下：
         *
         * public void sayHello(java.lang.String arg0) {
         *         Object[] args = new Object[1];
         *         args[0] = ($w) $1;
         *         Object ret = handler.invoke(this, methods[0], args);
         *     }
         *
         *
         * public void sayHello(java.lang.String arg0, java.lang.Integer arg1) {
         *         Object[] args = new Object[2];
         *         args[0] = ($w) $1;
         *         args[1] = ($w) $2;
         *         Object ret = handler.invoke(this, methods[1], args);
         *     }
         *
         *   public void sayHello(java.lang.String arg0, java.lang.String arg1) {
         *         Object[] args = new Object[2];
         *         args[0] = ($w) $1;
         *         args[1] = ($w) $2;
         *         Object ret = handler.invoke(this, methods[2], args);
         *     }
         *
         *     proxy0的构造方法：
         *     public <init>(java.lang.reflect.InvocationHandler arg0){
         *         handler = $1;
         *     }
         *
         */
        Proxy proxy = Proxy.getProxy(MyDemoInterface.class);
        System.out.println(proxy.toString());
    }
}
