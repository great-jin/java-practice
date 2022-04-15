package basis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.math.BigInteger;
import java.util.LinkedHashSet;

import cn.hutool.core.util.StrUtil;

public class StringTest {

    @Test
    public void ForDemo() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");

        list.forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * 根据指定字符拆分字符串为单词
     * <p>
     * StrUtil.isBlank(str)：判判断字符串是否为空
     */
    @Test
    public void StringDemo() {
        String origin = "id, name";
        Set<String> set = new LinkedHashSet();

        if (!StrUtil.isBlank(origin)) {
            for (String str : origin.split(",")) {
                set.add(str.trim());
            }
            System.out.println(set);
        } else {
            System.out.println("The original str is empty.");
        }
    }

    /**
     * StringBuilder提供一种可变的字符串类型
     * 速度快但不安全，适合单线程
     */
    @Test
    public void StringBuilderDemo() {
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
    @Test
    public void BigDecimalDemo() {
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
    @Test
    public void Seal() {
        int i = 0;
        // int i = null;           // 非法语句

        Integer integer_1 = null;
        Integer integer_2 = 1;
        System.out.println(integer_1);
        System.out.println(integer_2);
    }

    /**
     * hashCode()：对象散列值计算
     */
    @Test
    public void HashDemo() {
        String str = "hello";
        StringBuilder builder = new StringBuilder("hello");

        System.out.println("str" + str.hashCode());
        System.out.println("builder" + builder.hashCode());
    }
}
