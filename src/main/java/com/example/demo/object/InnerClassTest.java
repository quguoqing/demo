package com.example.demo.object;

/**
 * @author: chunmu
 * @Date: 2020/5/25 10:57
 * @Description:
 */
public class InnerClassTest {

    public static void main(String[] args){
        InnerClassTest classTest = new InnerClassTest();
        classTest.process(18, "张三");
    }



    private void process(int age, String name){
        InnerClass ic = new InnerClass();
        ic.setAge(age);
        ic.setName(name);
        System.out.println(ic);
    }



    class InnerClass {

        private int age;

        private String name;

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
