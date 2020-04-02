package com.example.demo.sort;

import java.util.Arrays;

/**
 * @author: chunmu
 * @Date: 2020/4/1 22:27
 * @Description:
 */
public class InsertSort {

    private static int times = 0;
    public static void main(String[] args){

        int[] org = new int[]{4,3,5,2,1,8,2,4,6,7};

        for(int i=1; i < org.length; i++){
            int current = org[i];
            for(int j=i-1; j>=0; j--){
                if(org[j] > current){
                    //插入到它前面
                    times++;
                    org[j+1] = org[j];
                    org[j] = current;
                }else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(org) + "，移动了" + times + "次");
    }

}
