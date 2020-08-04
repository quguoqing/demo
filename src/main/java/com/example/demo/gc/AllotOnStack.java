package com.example.demo.gc;

/**
 * @author: chunmu
 * @Date: 2020/7/3 15:34
 * @Description:
 */
public class AllotOnStack {

    public static void main(String[] args){
        Long start = System.currentTimeMillis();
        for(int i=0; i<100000000; i++){
            alloc();
        }
        System.out.println("spend=" + (System.currentTimeMillis() - start) + "ms");
    }

    private static void alloc(){
        User user = new User();
        user.setAge(18);
        user.setName("abc");
    }

    private static class User{

        int age;

        String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
