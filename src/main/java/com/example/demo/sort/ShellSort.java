package com.example.demo.sort;

import java.util.Arrays;

/**
 * @author: chunmu
 * @Date: 2020/4/1 23:02
 * @Description:
 */
public class ShellSort {

    private static int times = 0;

    public static void main(String[] args) {
        int[] org = new int[] { 4, 3, 5, 2, 1, 8, 2, 4, 6, 7 };
        //选择增量值，默认第一次=length/2。后面二分递减。
        for(int gap = org.length/2; gap > 0; gap /= 2){
            //对多组排序
            for(int i = gap; i < org.length; i++){
                gapInsertSort(org, gap, i);
            }
        }
        System.out.println(Arrays.toString(org) + "，比较了" + times + "次");
    }

    //一组排序
    private static void gapInsertSort(int[] org, int gap, int i) {
        int current = org[i];
        int j;
        for(j = i - gap; j >= 0 && current < org[j]; j-=gap){
            times++;
            org[j + gap] = org[j];
        }
        org[j + gap] = current;
    }
}
