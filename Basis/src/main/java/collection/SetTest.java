package collection;

import cn.hutool.json.JSONObject;
import org.junit.Test;
import java.util.*;

public class SetTest {

    /**
     * 非线程安全
     */
    @Test
    public void HashSetDemo(){
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
    @Test
    public void HashMapDemo(){
        Map<Integer, String> set = new HashMap<Integer, String>();
        set.put(1, "Alex");
        set.put(2, "Bob");
        set.remove(2);

        System.out.println(set);
    }

    /**
     * 键值对形式，线程安全
     */
    @Test
    public void HashTableDemo(){
        Map<Integer, String> map = new Hashtable<Integer, String>();
        map.put(1, "Alex");
        map.put(2, "Bob");
        map.remove(2);
        System.out.println(map);
    }

    /**
     * Map与Json格式转化
     */
    @Test
    public void TransDemo(){
        Map<Integer, String> map = new Hashtable<Integer, String>();
        map.put(1, "Alex");
        map.put(2, "Bob");

        System.out.println(new JSONObject(map));
    }

}
