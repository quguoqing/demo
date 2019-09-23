package com.example.demo.aop;

/**
 * @author: chunmu
 * @Date: 2019/9/17 21:05
 * @Description:
 */
public interface TicketService {

    //售票
    default int sellTicket(){
        return 1;
    }

    //问询
    void inquire();

    //退票
    void withdraw();

}
