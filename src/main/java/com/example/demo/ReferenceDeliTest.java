package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author: chunmu
 * @Date: 2020/4/20 10:09
 * @Description:
 */
public class ReferenceDeliTest {

    public static void main(String[] args){
        String a = new String("abc");
        String b = a;

        System.out.println("a=" + a);
        System.out.println("b=" + b);

        for(int i=0; i< 1000; i++){
            List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);

            List<Integer> temp = new ArrayList<>();
            List<Integer> result = nums.parallelStream().map(
                    num -> {
                        //线程不安全
                        temp.add(num);
                        System.out.print(num);
                        return new Integer(num.intValue());
                    }).collect(Collectors.toList());
            // if(temp.size() < 9){
            //     System.out.println(temp.toString());
            // }
            System.out.println(result.toString());

        }
    }

}
