import java.math.BigDecimal;
import java.math.BigInteger;

public class StringTest {
    public static void main(String[] args) {
        StringBuilderDemo();

        BigDecimalDemo();
    }

    /**
     * StringBuilder提供一种可变的字符串类型
     * 速度快但不安全，适合单线程
     */
    private static void StringBuilderDemo(){
        StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append("World!");
        // insert a char at index 5
        builder.insert(5, "J");
        // replace a char at index 5
        builder.setCharAt(5, ' ');

        final String finalString = builder.toString();
        System.out.println(finalString);
    }

    /**
     * 处理任意长度的数字序列长度
     */
    private static void BigDecimalDemo(){
        BigInteger one = BigInteger.valueOf(20);
        BigInteger two = BigInteger.valueOf(10);

        System.out.println(one.add(two));
        System.out.println(one.subtract(two));
        System.out.println(one.multiply(two));
        System.out.println(one.divide(two));
    }

    /**
     * 对象包装，将一般类型封装为对象，实现可实例化。
     */
    private static void Seal(){
        int i = 0;
        // int i = null;           // 非法语句

        Integer integer_1 = null;
        Integer integer_2 = new Integer(1);
    }


    /**
     * hashCode()：对象散列值计算
     */
    private static void HashFun(){
        String str = "hello";
        StringBuilder builder = new StringBuilder("hello");

        System.out.println("str" + str.hashCode());
        System.out.println("builder" + builder.hashCode());
    }
}
