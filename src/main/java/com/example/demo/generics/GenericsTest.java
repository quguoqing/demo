package com.example.demo.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: chunmu
 * @Date: 2020/2/14 23:36
 * @Description:
 */
public class GenericsTest {

    public static void main(String[] args){
        //1. 验证泛型 是不是语法糖。结论：是语法糖，javac在编译的时候，会解语法糖。
        // 字节码会擦除泛型类型，恢复原始类型。并自动添加强制类型转换，减少程序员编码出错的可能性
        // Map<String, String> map1 = new HashMap<>();
        // map1.put("1", "1");
        // Object str1 = map1.get("1");
        // Map<Integer, Integer> map2 = new HashMap<>();
        // map2.put(1, 1);
        // Object str2 = map2.get(1);

        //2. 验证数组越界 是不是语法糖？
        // 结论：
        // 1. 不是语法糖，javac不会在字节码层面添加if的越界检查指令
        // 2. JVM在执行数组访问指令时，会自动执行越界检查。越界的话，有JVM的c++代码抛出运行时异常

        // int[] a = new int[2];
        // a[0] = 0;
        // a[1] = 1;
        // int b = a[7];
        // System.out.println(b);

        //3. 验证锁消除，是javac优化还是JVM优化
        //结论：
        // 1.通过编译该main方法，使用javap查看字节码指令，发现字节码还是有monitorenter指令。说明javac不会消除
        // 2.这个锁必然会消除的，肯定就是JVM执行的时候，通过JIT编译消除
        Object lock = new Object();
        int i = 0;
        synchronized (lock){
            i += 1;
            try{
                lock.notify();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        System.out.println(i);
    }

}
