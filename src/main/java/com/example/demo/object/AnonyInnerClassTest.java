package com.example.demo.object;

/**
 * @author: chunmu
 * @Date: 2020/6/12 16:07
 * @Description:
 */
public class AnonyInnerClassTest {

    public static void main(String[] args){
        final ClassB  b = new ClassB(2);
        final ClassB  c = new ClassB(2);

        MyInterface target = new MyInterface(){
            @Override
            public int hello() {
                b.setA(3);
                return 0;
            }

            @Override
            public int helloWorld() {
                c.getA();
                return 1;
            }
        };
        target.hello();
    }
}
