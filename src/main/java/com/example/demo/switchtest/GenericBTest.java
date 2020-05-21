package com.example.demo.switchtest;

/**
 * @author: chunmu
 * @Date: 2020/5/20 17:18
 * @Description:
 */
public class GenericBTest<T> {

    private T name;

    public GenericBTest(T t){
        this.name = t;
    }

    public T getName(){
        return name;
    }

    public <E> E m1(E e){
        return e;
    }

    public <T> void m2(T t){
        System.out.println("m2=" + t);
    }

    public static void main(String[] args){
        GenericBTest<String> bTest = new GenericBTest("你好");
        String a = bTest.m1(bTest.getName());
        System.out.println(a);
        bTest.m2(bTest.getName());

        int b = bTest.m1(123);
        System.out.println(b);
        bTest.m2(b);
    }

}
