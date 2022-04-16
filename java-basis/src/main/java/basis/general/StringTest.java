package basis.general;

import org.junit.Test;

import java.util.*;
import java.math.BigInteger;

import cn.hutool.core.util.StrUtil;

public class StringTest {

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
     * 根据指定字符拆分字符串为单词
     * <p>
     * StrUtil.isBlank(str)：判判断字符串是否为空
     */
    @Test
    public void UtilDemo() {
        String origin = "id, name";
        List<String> list = new ArrayList<>();

        // if "origin" not be empty
        if (!StrUtil.isBlank(origin)) {
            for (String str : origin.split(",")) {
                list.add(str.trim());
            }
        } else {
            System.out.println("The original str is empty.");
        }
        System.out.println(list);
    }

    /**
     * StringBuilder提供一种可变的字符串类型
     * <p>
     * Fast but unsafe, suit for sing thread
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
     * hashCode()：对象散列值计算
     * <p>
     * same value can get difference hash values
     */
    @Test
    public void HashDemo() {
        String str = "hello";
        StringBuilder builder = new StringBuilder("hello");

        System.out.println("str: " + str.hashCode());
        System.out.println("builder: " + builder.hashCode());
    }
}
