package com.example.demo.sort;

import java.util.Arrays;

/**
 * @author: chunmu
 * @Date: 2020/4/1 21:51
 * @Description:
 */
public class BubbleSort {

    private static int times = 0;

    public static void main(String[] args){
        int[] org = new int[]{4,3,5,2,1,8,2,4,6,7};
        int length = org.length;
        while (length > 1){
            sort(org, length);
            length--;
        }
        System.out.println(Arrays.toString(org) + "，比较了" + times + "次");
    }

    private static void sort(int[] sort, int length){
        if(length == 1){
            return;
        }
        for(int i = 0; i < length - 1; i++){
            int first = sort[i];
            int after = sort[i+1];
            times++;
            if(first > after){
                //交换
                sort[i] = after;
                sort[i+1] = first;
            }
        }
    }
}
