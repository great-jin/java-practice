package collection;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        HashSetDemo();

        HashMapDemo();

        HashTableDemo();
    }

    /**
     * 非线程安全
     */
    private static void HashSetDemo(){
        Set<String> set = new HashSet<String>();
        set.add("Alex");
        set.add("Bob");
        set.add("Bob");     // 重复不添加
        set.remove("Bob");

        System.out.println(set.contains("Alex"));
    }

    /**
     * 键值对形式，非线程安全
     */
    private static void HashMapDemo(){
        Map<Integer, String> set = new HashMap<Integer, String>();
        set.put(1, "Alex");
        set.put(2, "Bob");
        set.remove(2);

        System.out.println(set);
    }

    /**
     * 键值对形式，线程安全
     */
    private static void HashTableDemo(){
        Map<Integer, String> set = new Hashtable<Integer, String>();
        set.put(1, "Alex");
        set.put(2, "Bob");
        set.remove(2);
        System.out.println(set);
    }
}
