package com.example.demo.dynamicProxy;

/**
 * @author: chunmu
 * @Date: 2019/8/29 20:39
 * @Description:
 */
public interface CountService {

    int count();

    default int count(int a){return a;}

}
