package com.example.demo.spi;

/**
 * @author: chunmu
 * @Date: 2019/10/27 17:37
 * @Description:
 */
public class ShadowTest {

    // public int x = 0;
    //
    // interface FirstLevel {
    //
    //     void methodInFirstLevel(int x);
    // }
    //
    // FirstLevel firstLevel = new FirstLevel() {
    //
    //     public int x = 1;
    //
    //     @Override
    //     public void methodInFirstLevel(int x) {
    //         System.out.println("x = " + x);
    //         System.out.println("this.x = " + this.x);
    //         System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
    //     }
    // };

    public static void main(String... args) {
        // IShot c = new Cat();
        // IShot d = new Dog();
        // ShadowTest shadowTest = new ShadowTest();
        // //打印 hi iShot
        // shadowTest.sayHello(c);
        // shadowTest.sayHello(d);
        //
        // Object cha = "b";
        // //打印 hi object
        // shadowTest.sayHello(cha);
        // //打印 hi char
        // shadowTest.sayHello('b');
        // //打印 hi object
        // shadowTest.sayHello("b");
    }

    public void sayHello(IShot iShot){
        System.out.println("hi iShot");
    }

    public void sayHello(Dog dog){
        System.out.println("hi dog");
    }

    public void sayHello(Cat cat){
        System.out.println("hi cat");
    }

    public void sayHello(Object object){
        System.out.println("hi object");
    }

    public void sayHello(char cha){
        System.out.println("hi char");
    }

}
