package collection;

import cn.hutool.json.JSONObject;
import org.junit.Test;
import java.util.*;

public class SetTest {

    /**
     * 非线程安全, 重复不添加
     */
    @Test
    public void HashSetDemo(){
        Set<String> set = new HashSet<>();
        set.add("Alex");
        set.add("Bob");
        set.add("Bob");
        set.add("Mark");
        set.remove("Bob");

        System.out.println(set);
        System.out.println(set.contains("Alex"));
    }

    /**
     * 键值对形式，非线程安全
     */
    @Test
    public void HashMapDemo(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Alex");
        map.put(2, "Bob");
        map.put(3, "mark");
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
        map.put(3, "mark");
        map.remove(2);

        System.out.println(map);
    }

}
