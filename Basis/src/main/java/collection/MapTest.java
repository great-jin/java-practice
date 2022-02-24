package collection;

import org.junit.Test;

import java.util.*;

public class MapTest {

    /**
     * 键值对形式，非线程安全
     */
    @Test
    public void HashMapDemo(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Alex");
        map.put(2, "Bob");
        map.put(3, "Mark");

        System.out.println(map);
    }

    /**
     * 性能低于 HashMap
     * 自带排序。基于红黑树实现
     */
    @Test
    public void TreeMapDemo(){
        Map<Integer, String> map = new TreeMap<>();
        map.put(2, "Bob");
        map.put(1, "Alex");
        map.put(3, "Mark");

        System.out.println(map);
    }

    /**
     * 以插入顺序保存元素
     * 键值对形式，线程安全
     */
    @Test
    public void LinkedHashMapDemo(){
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Alex");
        map.put(2, "Bob");
        map.put(3, "Mark");

        System.out.println(map);
    }

    /**
     * 键值对形式，线程安全
     */
    @Test
    public void HashTableDemo(){
        Map<Integer, String> map = new Hashtable<>();
        map.put(1, "Alex");
        map.put(2, "Bob");
        map.put(3, "Mark");
        map.remove(2);

        System.out.println(map);
    }
}
