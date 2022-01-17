package collection;

import java.util.*;

import bean.User;

public class ListTest {
    public static void main(String[] args) {
        ListDemo();

        LinkedListDemo();
    }

    private static void ListDemo() {
        // ArrayList是List的接口实现类。
        // List不能直接实例化对象，List list = new List();是非法的。
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Jack"));
        // 修改元素值
        list.set(0, new User(2, "Bob"));
        System.out.println(list);

        // 构造指定大小的列表
        List<User> list_1 = new ArrayList<>(100);
        System.out.println(list_1);
    }

    private static void LinkedListDemo() {
        // 链表，增删效率高
        LinkedList<String> list = new LinkedList<>();
        list.add("hello");
        list.add("world");
        list.addFirst("!!");
        System.out.println(list);

        for (String str : list ) {
            System.out.println(str);
        }
    }

}
