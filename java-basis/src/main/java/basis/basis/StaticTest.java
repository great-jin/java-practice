package basis.basis;

public class StaticTest {

    private int num1;           // 实例变量
    private static int num2;    // 静态变量

    public static void main(String[] args) {
        // 按静态块先后顺序自动执行其方法体
    }

    static {
        StaticTest test = new StaticTest();
        test.num1 = 10;
        System.out.println("静态块 1 : " + test.num1);
    }

    static {
        StaticTest.num2 = 20;
        System.out.println("静态块 2 : " + num2);
    }
}
