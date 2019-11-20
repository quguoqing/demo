package com.example.demo.cache;

/**
 * @author: chunmu
 * @Date: 2019/11/19 21:03
 * @Description:
 */
public class MyGate {

    private Boolean isOpen = false;

    /**
     * 0：灭，1：绿灯，2：黄灯，3：红灯
     */
    private int light = 0;


    public MyGate(boolean isOpen, int light){
        this.isOpen = isOpen;
        this.light = light;
    }


}
