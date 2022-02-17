package collection;

import java.util.*;

import bean.User;
import org.junit.Test;

public class ListTest {
    
    /**
     * ArrayList是List的接口实现类。
     * List不能直接实例化对象，List list = new List();是非法的。
     */
    @Test
    public  void ListDemo() {
        List<String> list = new ArrayList<>();
        list.add("Jack");
        list.add("Mark");

        // 修改元素值
        list.set(0, "Bob");
        System.out.println(list);

        // 构造指定大小的列表
        List<String> list1 = new ArrayList<>(100);
    }

    /**
     * 链表，增删效率高
     */
    @Test
    public  void LinkedListDemo() {
        LinkedList<String> list = new LinkedList<>();
        list.add("hello");
        list.add(" ");
        list.add("world");
        list.add("!");
        list.addFirst("Message：");

        System.out.println(list);
    }

    @Test
    public  void Conbination() {
        List<Map<Integer, String>> list = new ArrayList<>();
        Map<Integer, String> set = new HashMap<Integer, String>();
        set.put(1, "Alex");
        set.put(2, "Bob");
        list.add(set);

        System.out.println(list);
    }

}
