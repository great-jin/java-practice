package collection;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        HashSetDemo();

        HashMapDemo();

        HashTableDemo();
    }

    private static void HashSetDemo(){
        // 非线程安全
        Set<String> set = new HashSet<String>();
        set.add("Alex");
        set.add("Bob");
        set.add("Bob");     // 重复不添加
        set.remove("Bob");
        System.out.println(set.contains("Alex"));
    }

    private static void HashMapDemo(){
        // 键值对形式，线程安全
        Map<Integer, String> set = new HashMap<Integer, String>();
        set.put(1, "Alex");
        set.put(2, "Bob");
        set.remove(2);
        System.out.println(set);
    }

    private static void HashTableDemo(){
        // 键值对形式，线程安全
        Map<Integer, String> set = new Hashtable<Integer, String>();
        set.put(1, "Alex");
        set.put(2, "Bob");
        set.remove(2);
        System.out.println(set);
    }
}
