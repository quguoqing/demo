package com.example.demo.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: chunmu
 * @Date: 2020/4/7 21:16
 * @Description:
 */
public class StringSort {

        public static void main(String[] args) {
            Character[] value = {'c', 'd', 'b', 'b', 'a', 'c', 'a', 'b', 'd'};
            Set<Character> mark = new HashSet<>();
            mark.add('a');
            mark.add('b');
            mark.add('c');
            mark.add('d');

            int min = value.length;
            Character[] minValue = null;
            for(int i=0; i< value.length; i++){
                Character[] temp = match(value, i, mark);
                if(null != temp && temp.length < min){
                    min = temp.length;
                    minValue = temp;
                }
            }
            System.out.println(Arrays.toString(minValue));
        }

        private static Character[] match(Character[] value,int start, Set<Character> mark){
            int end = start + mark.size();
            for(; end <= value.length; end++){
                Character[] sub = Arrays.copyOfRange(value, start, end);
                if(isMatch(sub)){
                    //匹配了，该value串已经找到最小的
                    return sub;
                }
            }
            return null;
        }

        private static boolean isMatch(Character[] subValue){
            Set<Character> temp = new HashSet<>(Arrays.asList(subValue));
            if(temp.contains('a') && temp.contains('b') && temp.contains('c') && temp.contains('d')){
                return true;
            }
            return false;
        }

}
