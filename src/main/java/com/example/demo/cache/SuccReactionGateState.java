package com.example.demo.cache;

/**
 * @author: chunmu
 * @Date: 2019/11/19 21:20
 * @Description:
 */
public class SuccReactionGateState implements GateState {

    @Override
    public void handle() {
        System.out.println("感应成功");
    }
}
