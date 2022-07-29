package collection.util;

import bean.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    /**
     * 串行: 在可能存在共享资源、线程安全等问题的时候使用
     * <p>
     * 并行: 在无线程安全问题的前提下，并且单纯的数据处理的时候使用
     */
    @Test
    public void StreamDemo() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
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
        list.add(new User("张三", 20));
        list.add(new User("李四", 20));
        list.add(new User("李四", 30));

        System.out.println("-------- 数据过滤 ----------");
        User user = list.stream()
                .filter(item -> item.getAge() == 20)
                .findAny()
                .orElse(null);
        System.out.println(user);

        System.out.println("-------- 数据去重 ----------");
        List<String> uniqueList = list.stream()
                .map(User::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueList);
    }

    /**
     * List<String> to List<Integer>
     */
    @Test
    public void ConvertDemo() {
        String str = "1,2,3,4,5";
        List<String> idList = Arrays.asList(StringUtils.split(str, ","));
        List<Integer> ids = idList.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(ids);
    }
}
