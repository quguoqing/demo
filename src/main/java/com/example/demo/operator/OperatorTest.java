package com.example.demo.operator;

import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.JSON;

/**
 * @author: chunmu
 * @Date: 2020/6/28 11:44
 * @Description:
 */
public class OperatorTest {

    private static int SHARED_SHIFT = 16;

    public static void main(String[] args){
        String result = Integer.toBinaryString(1);
        System.out.println(buildRealBinaryString(result, 32) + ";value=" + 1);
        int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
        System.out.println(buildRealBinaryString(Integer.toBinaryString(EXCLUSIVE_MASK), 32) + ";value=" + EXCLUSIVE_MASK);

        System.out.println(1 & EXCLUSIVE_MASK);

        System.out.println(1 >>> SHARED_SHIFT);


        char c1_0 = (char)18890;
        System.out.println("c1_0=" + c1_0);
        char c1_1 = (char) (18890 + 65536);
        System.out.println("c1_1=" + c1_1);
        char c1_2 = (char) (18890 + 65536 + 65536);
        System.out.println("c1_2=" + c1_2);
        char c2 = '䧊';
        System.out.println("c2=" + c2);

        // char c = '\uD844\uDCC1';

        //s=𡃁妹
        String s = "\uD844\uDCC1妹";
        System.out.println(s);
        System.out.println("\uD844\uDCC1妹 char array size=" + s.length());
        String binary = "";
        for(char c : s.toCharArray()){
            String charBinary = buildRealBinaryString(Integer.toBinaryString(c), 16);
            System.out.println("s char=" + c + "; int value=" + Integer.valueOf(c) +  "; binary=" + charBinary);
            binary += charBinary;
        }
        System.out.println("binary=" + binary);


        String s1 = "\uD86D\uDDAF";
        System.out.println("s1=" + s1);
        System.out.println("s1 char array size=" + s1.length());
        // char c1 = '\uD86D\uDDAF';

        try {
            byte[] array1 = buildByteArray(binary);
            byte[] array2 = s.getBytes("utf-16");
            System.out.println("array1=" + JSON.toJSONString(array1));
            System.out.println("array2=" + JSON.toJSONString(array2));

            String s3 = new String(array2, "utf-16");
            System.out.println("s3=" + s3);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    private static String buildRealBinaryString(String result, int length){
        int left = length - result.length();
        if(left <= 0){
            //无需补0
            return result;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<left; i++){
            sb.append("0");
        }
        return sb.toString() + result;
    }

    private static byte[] buildByteArray(String binary){
        byte[] result = new byte[binary.length()];
        for(int i=0; i<binary.length(); i++){
            result[i] = Integer.valueOf(binary.charAt(i)).byteValue();
        }
        return result;
    }

    private static int exclusiveCount(int c, int EXCLUSIVE_MASK) {
        return c & EXCLUSIVE_MASK;
    }


}
