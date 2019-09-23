package com.example.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.aop.RailwayStation;
import com.example.demo.aop.TicketService;
import com.example.demo.bean.ServiceA;

/**
 * @author: chunmu
 * @Date: 2019/9/17 21:16
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketServiceTest {

    // @Resource
    // private TicketService ticketService;

    @Resource
    private RailwayStation railwayStation;

    @Resource
    private ServiceA serviceA;

    @Test
    public void test_inquire(){
        railwayStation.inquire();
    }

    @Test
    public void test_hello(){
        serviceA.hello();
    }

}
