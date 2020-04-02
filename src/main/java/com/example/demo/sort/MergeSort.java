package com.example.demo.sort;

import java.util.Arrays;

/**
 * @author: chunmu
 * @Date: 2020/4/1 23:34
 * @Description:
 */
public class MergeSort {

    private static int times = 0;
    public static void main(String[] args) {
        int[] org = new int[] { 4, 3, 5, 2, 1,7,3};
        int[] result = mergeSort(org);
        System.out.println(Arrays.toString(result));
    }

    private static int[] mergeSort(int[] org){
        if(org.length <= 1){
            //数组最多只有一个元素，肯定有序
            return org;
        }
        int middle = org.length / 2;
        //分段
        int[] left = Arrays.copyOfRange(org, 0, middle);
        int[] right = Arrays.copyOfRange(org, middle, org.length);
        //递归合并
        int[] mergeLeft = mergeSort(left);
        int[] mergeRight = mergeSort(right);
        return merge(mergeLeft, mergeRight);
    }

    //合并，并排序
    private static int[] merge(int[] left, int[] right){
        System.out.println("left=" + Arrays.toString(left) + ", right=" + Arrays.toString(right));
        if(left.length == 0 && right.length > 0){
            return right;
        }
        if(left.length > 0 && right.length == 0){
            return left;
        }
        //两边都有数据
        int leftIndex = 0;
        int rightIndex = 0;
        int[] result = new int[left.length + right.length];
        for(int i=0; i < result.length; i++){
            if(leftIndex >= left.length){
                //左边耗尽，右边追加进来
                result[i] = right[rightIndex];
                rightIndex++;
                continue;
            }
            if(rightIndex >= right.length){
                //右边耗尽，左边追加进来
                result[i] = left[leftIndex];
                leftIndex++;
                continue;
            }
            //两边都有，依次合并进来
            int min;
            if(left[leftIndex] <= right[rightIndex]){
                min = left[leftIndex];
                leftIndex++;
            } else {
                min = right[rightIndex];
                rightIndex++;
            }
            result[i] = min;
        }
        System.out.println("merge=" + Arrays.toString(result));
        return result;
    }

}
