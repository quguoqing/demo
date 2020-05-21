package com.example.demo.switchtest;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * @author: chunmu
 * @Date: 2020/5/12 12:57
 * @Description:
 */
public class SwitchTest {

    public static int test(int num){
        int num1;
        switch (num){
            case 1:
                num1 = 1;
                break;
            case 3:
                num1 = 3;
                break;
            case 5:
                num1 = 5;
                break;
            case 7:
                num1 = 7;
                break;
            case 9:
                num1 = 9;
                break;
            default:
                num1 = 1;
                break;
        }
        return num1;
    }

    public static int ifTest(int num){
        int num1;
        if(num == 1){
            num1 = 1;
        }else if(num == 3){
            num1 = 3;
        }
        else if(num == 5){
            num1 = 5;
        }else if(num == 7){
            num1 = 7;
        }else if(num == 9){
            num1 = 9;
        }else {
            num1 = -1;
        }
        return num1;
    }

    public static void main(String[] args){
        test(9);
        ifTest(9);
    }


}
