package com.example.demo.object;

/**
 * @author: chunmu
 * @Date: 2020/2/18 21:38
 * @Description:
 */
public class ClassA {

    private int i = 100;

    private int j;

    private int g;

    {
        j = 200;
    }

    public ClassA(int g){
        this.g = g;
    }

    public ClassA(){
    }
}
