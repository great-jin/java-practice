package basis.upgrade.collection;

import org.junit.Test;

import java.util.*;

public class IteratorTest {

    @Test
    public void IterateDemo() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        System.out.println(list);

        // 利用迭代器遍历集合
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // 效果同迭代器遍历，更常用
        for (String str : list) {
            System.out.println(str);
        }
    }

    @Test
    public void ListIterateDemo() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        System.out.println(list);

        ListIterator<String> iter = list.listIterator();
        // 此时在 "World"
        iter.next();
        // 返回 "World" 的前一位
        System.out.println(iter.previous());
    }
}
