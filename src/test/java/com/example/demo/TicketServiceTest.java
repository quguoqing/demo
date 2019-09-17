package com.example.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.aop.TicketService;

/**
 * @author: chunmu
 * @Date: 2019/9/17 21:16
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketServiceTest {

    @Resource
    private TicketService ticketService;

    @Test
    public void test_inquire(){
        ticketService.inquire();
    }

}
