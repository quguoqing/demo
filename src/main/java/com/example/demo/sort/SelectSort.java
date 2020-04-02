package com.example.demo.sort;

import java.util.Arrays;

/**
 * @author: chunmu
 * @Date: 2020/4/1 22:09
 * @Description:
 */
public class SelectSort {
    public static void main(String[] args){
        int[] org = new int[]{4,3,5,2,1,8,2,4,6,7};
        int times = 0;
        for(int i=0; i<org.length;i++){
            int index = i;
            int min = org[i];
            for(int j = i+1; j < org.length; j++){
                times++;
                if(org[j] < min){
                    min = org[j];
                    index = j;
                }
            }
            //交换
            org[index] = org[i];
            org[i] = min;
        }
        System.out.println(Arrays.toString(org) + "，比较了" + times + "次");
    }
}
