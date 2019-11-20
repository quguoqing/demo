package com.example.demo.cache;

/**
 * @author: chunmu
 * @Date: 2019/11/19 21:26
 * @Description:
 */
public class GateStateFactory {

    /**
     * 工厂模式，得到状态
     * @param isOpen，true:open,false:close
     * @param behavior 1：刷卡，2：通过。可以定义为枚举
     * @return
     */
    public GateState buildSuccReactionGateState(boolean isOpen, int behavior){
        if(!isOpen && behavior == 1){
            return new SuccReactionGateState();
        }else if(isOpen && behavior == 1){
            return new SuccPayGateState();
        }else if(isOpen && behavior == 2){
            return new SuccPassGateState();
        }else {
            return null;
        }
    }

    public GateState buildSuccPayGateState(){
        return new SuccPassGateState();
    }
}
