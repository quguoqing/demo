package com.example.demo.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: chunmu
 * @Date: 2019/9/16 20:00
 * @Description:
 */
@Component
public class ServiceB {

    @Autowired
    // ServiceA serviceA;


    public static void main(String[] args){
        // Long time = 1568857222306L;
        // Date date = new Date(time);
        //
        // // 设置北京时区
        // SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        //
        // // 设置东京时区
        // SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        //
        // // 设置伦敦时区
        // SimpleDateFormat londonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // londonSdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        //
        //
        // System.out.println("毫秒数:" + date.getTime() + ", 北京时间:" + bjSdf.format(date));
        // System.out.println("毫秒数:" + date.getTime() + ", 东京时间:" + tokyoSdf.format(date));
        // System.out.println("毫秒数:" + date.getTime() + ", 伦敦时间:" + londonSdf.format(date));

        Date time1 = new Date(-1000L);
        System.out.println(time1.toString());

        Date time2 = new Date(0L);
        System.out.println(time2.toString());

        Date time3 = new Date(1000L);
        System.out.println(time3.toString());

        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            Long time4 = tokyoSdf.parse("2050-12-01 00:00:00").getTime();
            System.out.println(time4);
            Date time5 = new Date(time4);
            System.out.println(time5.toString());

            Timestamp timestamp = new Timestamp(time4);
            System.out.println("timestamp=" + timestamp.toString());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
