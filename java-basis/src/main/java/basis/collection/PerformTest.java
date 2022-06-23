package basis.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PerformTest {

    /**
     * 遍历集合
     */
    @Test
    public void IterateDemo() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            list.add("element " + i);
        }

        // 利用迭代器遍历集合
        Iterator<String> iter = list.iterator();
        // iter.previous()
        System.out.println("迭代器遍历");
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
        }
        System.out.println();

        // 效果同迭代器遍历，更常用
        System.out.println("for循环遍历");
        for (String str : list) {
            System.out.print(str + ", ");
        }
        System.out.println();

        // 使用 lambda 表达式遍历
        System.out.println("lambda循环遍历");
        list.forEach(str -> {
            System.out.print(str + ", ");
        });
        System.out.println();

        // 串行流遍历
        System.out.println("单管流遍历");
        list.stream().forEach(str -> {
            System.out.print(str + ", ");
        });
        System.out.println();

        // 并发流遍历
        System.out.println("并发流遍历");
        list.parallelStream().forEach(str -> {
            System.out.print(str + ", ");
        });
        System.out.println();
    }

    /**
     * Performance testing
     */
    @Test
    public void PerformTest() {
        long begin, end;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(String.valueOf(i));
        }

        for (int i = 1; i < 20; i++) {
            System.out.println("------------------ 第" + i + "次测试 ------------------ ");
            begin = System.nanoTime();
            for (String s : list) {
                s.toString();
            }
            end = System.nanoTime();
            System.out.println("普通 for 循环耗时: " + (end - begin) / 1000 + " μs");

            begin = System.nanoTime();
            list.forEach(e -> {
                e.toString();
            });
            end = System.nanoTime();
            System.out.println("lambda 表达式 foreach 耗时: " + (end - begin) / 1000 + " μs");

            begin = System.nanoTime();
            list.stream().forEach(e -> {
                e.toString();
            });
            end = System.nanoTime();
            System.out.println("单管道 stream 耗时: " + (end - begin) / 1000 + " μs");

            begin = System.nanoTime();
            list.parallelStream().forEach(e -> {
                e.toString();
            });
            end = System.nanoTime();
            System.out.println("并行流 stream 耗时: " + (end - begin) / 1000 + " μs");
            System.out.println();
        }
    }
}
