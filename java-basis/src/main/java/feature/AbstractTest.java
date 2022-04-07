package feature;

public class AbstractTest {
    public static void main(String[] args) {
        AbsSonTest absSonTest = new AbsSonTest();
        int sum = absSonTest.AddElem(10, 20);
        System.out.println(sum);
    }
}


/**
 * 抽象类不能实例化
 * 方法不能包含方法体
 * 包含抽象方法的类必须为抽象类
 */
abstract class AbsFather {

    public abstract int AddElem(int a, int b);

}


/**
 * 一个类可以实现多个接口类，但只能继承一个父类
 * 子类必须继承父类所以抽象方法，否则必须声明为抽象类
 */
class AbsSonTest extends AbsFather {

    @Override
    public int AddElem(int a, int b) {
        return a + b;
    }
}
