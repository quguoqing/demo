package com.example.demo.cache;

/**
 * @author: chunmu
 * @Date: 2019/11/19 21:24
 * @Description:
 */
public class SuccPassGateState implements GateState{

    @Override
    public void handle() {
        System.out.println("放行成功");
    }
}
