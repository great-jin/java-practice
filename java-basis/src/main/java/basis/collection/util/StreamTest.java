package basis.collection.util;

import basis.bean.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    /**
     * 串行: 再在可能存在共享资源、线程安全等问题的时候使用
     * <p>
     * 并行: 在无线程安全问题的前提下，并且单纯的数据处理的时候使用
     */
    @Test
    public void StreamDemo() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            list.add(i);
        }

        // 单线程执行，顺序遍历
        list.stream().forEach(str -> {
            System.out.print(str + ", ");
        });
        System.out.println();

        // 多线程并发执行，结果随机
        list.parallelStream().forEach(str -> {
            System.out.print(str + ", ");
        });
    }

    /**
     * Java 8 自带的流处理列表
     */
    @Test
    public void UtilDemo() {
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(new User(String.valueOf(i), i));
        }

        System.out.println("-------- 单管流 ----------");
        list.stream().forEach(record -> {
            System.out.println(record);
        });

        System.out.println("-------- 并发流 ----------");
        list.parallelStream().forEach(record -> {
            System.out.println(record);
        });

        System.out.println("-------- 数据过滤 ----------");
        User target = list.stream()
                .filter(user -> user.getAge() == 1)
                .findAny()
                .orElse(null);
        System.out.println(target);

        System.out.println("-------- 数据去重 ----------");
        List<Integer> ageList = list.stream()
                .map(User::getAge)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(ageList);
    }
}
