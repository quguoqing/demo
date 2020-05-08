package com.example.demo.ieee754;

import java.math.BigDecimal;

/**
 * @author: chunmu
 * @Date: 2019/10/16 19:49
 * @Description:
 *
 * 解释：https://www.zhihu.com/question/28551135
 * 浮点数的⼆进制表示
 * ⾸先我们要了解浮点数⼆进制表示, 有以下两个原则:
 *  - 整数部分对 2 取余然后逆序排列
 *  - ⼩数部分乘 2 取整数部分, 然后顺序排列
 * 0.1 的表示是什么?
 * 我们继续按照浮点数的⼆进制表示来计算
 * 0.1 * 2 = 0.2 整数部分取 0
 * 0.2 * 2 = 0.4 整数部分取 0
 * 0.4 * 2 = 0.8 整数部分取 0
 * 0.8 * 2 = 1.6 整数部分取 1
 * 0.6 * 2 = 1.2 整数部分取 1
 * 0.2 * 2 = 0.4 整数部分取 0
 * …
 * 所以你会发现, 0.1 的⼆进制表示是 0.00011001100110011001100110011……0011
 * 0011 作为⼆进制⼩数的循环节不断的进⾏循环.
 * 这就引出了⼀个问题, 你永远不能存下 0.1 的⼆进制, 即使你把全世界的硬盘都放在⼀起, 也存不下 0.1 的⼆
 * 进制⼩数
 */
public class IEEE754 {

    public static void main(String[] args){
        double a = 0.2;
        BigDecimal ad = new BigDecimal(a);
        BigDecimal ads = new BigDecimal(String.valueOf(a));
        double b = 0.1;

        System.out.println("a=" + a);
        System.out.println("b=" + b);
        BigDecimal bd = new BigDecimal(b);
        BigDecimal bds = new BigDecimal(String.valueOf(b));

        System.out.println("b=" + b);
        System.out.println("a+b=" + (a + b));
        System.out.println("ad + bd = " + ad.add(bd).toString());
        System.out.println("ads + bds = " + ads.add(bds).toString());


        float c = 0.91f;
        System.out.println(String.valueOf(c));

        System.out.println(a + b == c);
    }

}
