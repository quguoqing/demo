package com.example.demo.switchtest;

/**
 * @author: chunmu
 * @Date: 2020/5/20 11:54
 * @Description:
 */
public class GenericATest <T extends Number> {

    private T a;

    private T b;

    public GenericATest(T a, T b){
        this.a = a;
        this.b = b;
    }

    public void setA(T a) {
        this.a = a;
    }

    public void setB(T b) {
        this.b = b;
    }

    public T getA() {
        return a;
    }

    public T getB() {
        return b;
    }

    public static void main(String[] args){
        GenericATest<Integer> aTest = new GenericATest(1,2);
        Integer a = aTest.getA();
        Integer b = aTest.getB();
        System.out.println(a);
        System.out.println(b);
    }
}


