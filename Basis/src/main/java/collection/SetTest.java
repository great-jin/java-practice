package collection;

import org.junit.Test;
import java.util.*;

public class SetTest {

    /**
     * 无序
     * 非线程安全, 重复不添加
     * 元素可以是 null, 但只能放入一个 null
     */
    @Test
    public void HashSetDemo(){
        Set<String> set = new HashSet<>();
        set.add("Alex");
        set.add("Bob");
        set.add("Bob");
        set.add("Mark");

        System.out.println(set);
        System.out.println(set.contains("Alex"));
    }

    /**
     * 以插入顺序保存元素
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

    /**
     * 集合元素处于排序状态
     * TreeSet是SortedSet接口的唯一实现类
     */
    @Test
    public void TreeSetDemo(){
        Set set = new TreeSet();
        set.add("B");
        set.add("A");
        set.add("C");

        System.out.println(set);
    }
}
