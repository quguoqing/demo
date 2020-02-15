package com.example.demo.dynamicProxy.jdk;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

/**
 * @author: chunmu
 * @Date: 2020/2/14 21:32
 * @Description:
 */
public class JDKDynamicProxyTest {

    public static void main(String[] args){
        IHello hello = new MyHello();
        MyHelloHandler handler = new MyHelloHandler(hello);
        IHello proxy = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(), new Class[]{IHello.class}, handler);
        proxy.hello("qu guo qing");
        saveClassBytes();
    }

    public static void saveClassBytes(){
        String name = "helloProxy";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{IHello.class});
        try{
            String helloProxy = "/Users/quguoqing/Documents/helloProxy";
            FileOutputStream out = new FileOutputStream( helloProxy + ".class" );
            out.write(data);
            out.close();
        }catch( Exception e ) {
            e.printStackTrace();
        }
    }

}
