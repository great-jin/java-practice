package basis.character;

public class AbstractTest {
    public static void main(String[] args) {
        Abs absSon = new AbsSon();
        absSon.hello();

        int sum = absSon.AddElem(10, 20);
        System.out.println(sum);
    }
}

/**
 * 抽象类不能实例化，方法不能包含方法体
 * 包含抽象方法的类必须为抽象类
 */
abstract class Abs {
    public abstract int AddElem(int a, int b);

    public void hello(){
        System.out.println("father hello");
    }

    /**
     * 抽象类可以包含静态块，接口则不合法
     *
     * 实例化类后将自动执行
     */
    static{
        System.out.println("I am static info");
    }
}


/**
 * 一个类可以实现多个接口类，但只能继承一个父类
 * 子类必须继承父类所以抽象方法，否则必须声明为抽象类
 */
class AbsSon extends Abs {

    @Override
    public void hello() {
        System.out.println("son hello");
    }

    @Override
    public int AddElem(int a, int b) {
        return a + b;
    }
}





