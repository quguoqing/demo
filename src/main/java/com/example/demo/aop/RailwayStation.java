package com.example.demo.aop;

/**
 * @author: chunmu
 * @Date: 2019/9/17 21:05
 * @Description:
 */
public class RailwayStation implements TicketService {

    @Override
    public void sellTicket(){
        System.out.println("售票............");
    }

    @Override
    public void inquire() {
        System.out.println("问询.............");
    }

    @Override
    public void withdraw() {
        System.out.println("退票.............");
    }
}
