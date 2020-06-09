package com.example.demo.lock;

/**
 * @author: chunmu
 * @Date: 2020/6/5 15:27
 * @Description:
 */
public class SynchLockTest {

    private static int share = 0;



    public static void main(String[] args) {
        int[] nums = new int[2];
        nums[0] = 1;
        nums[1] = 0;
        solution1(nums);
    }


    private static void solution2(int[] nums){
        int zeroIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                //第一个非0，交换给0位置
                nums[zeroIndex]=nums[i];
                if(zeroIndex != i){
                    //把0交换给正确位置
                    nums[i]=0;
                }
                //0位置自增
                zeroIndex++;
            }
        }
    }

    //遍历0和非0的位置，遇到即交换。
    static int i = 0;
    static int j = 0;
    private static void solution1(int[] nums){
        for(int start=0; start<nums.length;start++){
            int zeroIndex = findFristZeroIndex(nums, i+1);
            if(zeroIndex == -1){
                //没有0
                return;
            }
            i = zeroIndex;
            if(j < i){
                j = i;
            }
            int notZeroIndex = findFristNotZeroIndex(nums, j+1);
            if(notZeroIndex == -1){
                //遍历结束，没有非0，表示无需交换了
                return;
            }
            j = notZeroIndex;
            swap(nums, zeroIndex, notZeroIndex);
        }
    }

    private static int findFristZeroIndex(int[] nums, int start){
        for(;start<nums.length;start++){
            if(nums[start] == 0){
                return start;
            }
        }
        return -1;
    }

    private static int findFristNotZeroIndex(int[] nums, int start){
        for(;start<nums.length;start++){
            if(nums[start] != 0){
                return start;
            }
        }
        return -1;
    }


    private static void swap(int[] nums, int front, int back){
        int temp = nums[front];
        nums[front] = nums[back];
        nums[back] = temp;
    }

    private void solution3(int[] nums){
        int fristZeroIndex = 0;
        for(int i=0; i<nums.length;i++){
            if(nums[i] != 0){
                swap(nums, fristZeroIndex, i);
                fristZeroIndex++;
            }
        }
        // for(int i=fristZeroIndex; i<nums.length;i++){
        //     nums[fristZeroIndex] = 0;
        // }
    }

}
