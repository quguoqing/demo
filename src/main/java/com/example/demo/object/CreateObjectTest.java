package com.example.demo.object;

import java.lang.reflect.Constructor;

/**
 * @author: chunmu
 * @Date: 2020/2/18 21:26
 * @Description:
 */
public class CreateObjectTest {

    public static void main(String[] args) throws Exception{
        ClassA a1 = new ClassA();
        ClassA a2 = ClassA.class.newInstance();
        ClassA a3 = ClassA.class.getConstructor().newInstance();
    }

}
