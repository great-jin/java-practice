package collection;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        IterateDemo();

        ListIterateDemo();
    }

    private static void IterateDemo() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("!!!!!");
        System.out.println(list);

        // 利用迭代器遍历集合
        Iterator iter = list.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        // 效果同迭代器遍历，更常用
        for (String str : list ) {
            System.out.println(str);
        }
    }

    private static void ListIterateDemo() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("!!!!!");
        System.out.println(list);

        ListIterator iter = list.listIterator();
        iter.next();
        System.out.println(iter.previous());
    }
}
