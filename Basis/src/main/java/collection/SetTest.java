package collection;

import org.junit.Test;
import java.util.*;

public class SetTest {

    /**
     * 无序
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
     * 有序
     * 非线程安全, 重复不添加
     * 性能可能略低于 HashSet
     */
    @Test
    public void LinkedHashSetDemo(){
        Set<String> set = new LinkedHashSet<>();
        set.add("Alex");
        set.add("Bob");
        set.add("Bob");
        set.add("Mark");

        System.out.println(set);
        System.out.println(set.contains("Alex"));
    }

}
