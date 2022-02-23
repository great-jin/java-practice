package collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

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
        map.remove(2);

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

    /**
     * 有序
     * 键值对形式，线程安全
     */
    @Test
    public void LinkedHashMapDemo(){
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Alex");
        map.put(2, "Bob");
        map.put(3, "Mark");
        map.remove(2);

        System.out.println(map);
    }
}
