package com.example.demo.cache;

/**
 * @author: chunmu
 * @Date: 2019/11/19 21:23
 * @Description:
 */
public class SuccPayGateState implements GateState {

    @Override
    public void handle() {
        System.out.println("支付成功，开闸");
    }
}
