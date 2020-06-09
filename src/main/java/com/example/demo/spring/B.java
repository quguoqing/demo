package com.example.demo.spring;

/**
 * @author: chunmu
 * @Date: 2020/5/19 23:16
 * @Description:
 */
@MyAnnotation(value = "张三", age = 19)
public class B {

    public static void main(String[] args){
        Class<B> bClass = B.class;
        MyAnnotation annotation = bClass.getAnnotation(MyAnnotation.class);
        int age = annotation.age();
        String name = annotation.value();
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
