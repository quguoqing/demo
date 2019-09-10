package com.example.demo.dynamicProxy;

/**
 * @author: chunmu
 * @Date: 2019/8/29 20:40
 * @Description:
 */
public class CountServiceImpl implements CountService {

    private int count = 0;

    @Override
    public int count() {
       return count++;
    }
}
