package com.example.demo.aop;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: chunmu
 * @Date: 2019/9/17 21:05
 * @Description:
 */
@Service
public class RailwayStation implements TicketService {

    @Override
    public int sellTicket(){
        System.out.println("售票............");
        return 2;
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
