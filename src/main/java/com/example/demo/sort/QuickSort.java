package com.example.demo.sort;

import java.util.Arrays;

/**
 * @author: chunmu
 * @Date: 2020/4/2 00:11
 * @Description:
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] org = new int[] { 4, 3, 5, 2, 1,7,3,6,2};
        quickSort(org, 0, org.length - 1);
        System.out.println(Arrays.toString(org));
    }

    private static void quickSort(int[] org, int leftIndex, int rightIndex){
        System.out.println("quickSort start=" + Arrays.toString(Arrays.copyOfRange(org, leftIndex, rightIndex+1)));
        if(leftIndex >= rightIndex){
            return;
        }
        int key = org[leftIndex];
        int left = leftIndex;
        int right = rightIndex;
        while (left < right){
            //从后向前找第一个小于key，并交换
            while(right > left && org[right] >= key){
                right--;
            }
            org[left] = org[right];

            //从前向后找第一个大于key，并交换
            while (left < right && org[left] <= key){
                left++;
            }
            org[right] = org[left];
        }
        //基准值归位
        org[left] = key;
        System.out.println("quickSort end=" + Arrays.toString(Arrays.copyOfRange(org, leftIndex, rightIndex+1)));
        //分治的核心，递归左边
        quickSort(org, leftIndex, left-1);
        //递归右边
        quickSort(org, right+1, rightIndex);
    }

}
