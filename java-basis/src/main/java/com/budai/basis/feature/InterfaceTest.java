package com.budai.basis.feature;

public class InterfaceTest {
    public static void main(String[] args) {
        InterTest interTest = new InterTestImpl();
        int sum = interTest.AddElem(10, 20);
        System.out.println(sum);
    }
}


interface InterTest {

    int AddElem(int a, int b);

}


/**
 * 一个类可以实现多个接口类，但只能继承一个父类
 */
class InterTestImpl implements InterTest {

    @Override
    public int AddElem(int a, int b) {
        return a + b;
    }
}
