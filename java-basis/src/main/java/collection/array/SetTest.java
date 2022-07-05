package collection.array;

import org.junit.Test;

import java.util.*;

public class SetTest {

    /**
     * 非线程安全, 重复不添加
     * 存储根据哈希值，无先后次序
     * 元素可以是 null, 但只能放入一个 null
     */
    @Test
    public void HashSetDemo() {
        Set<String> set = new HashSet<>();
        set.add("Alex");
        set.add("Beth");
        // 重复不添加
        set.add("Beth");
        System.out.println(set);
    }

    /**
     * 以插入顺序保存元素
     * 非线程安全, 重复不添加
     * 性能可能略低于 HashSet
     */
    @Test
    public void LinkedHashSetDemo() {
        Set<String> set = new LinkedHashSet<>();
        set.add("Alex");
        set.add("Beth");
        set.add("Mark");
        System.out.println(set);
    }

    /**
     * 自带排序，集合元素处于排序状态
     * TreeSet 是 SortedSet 接口的唯一实现类
     */
    @Test
    public void TreeSetDemo() {
        Set<String> set = new TreeSet<>();
        set.add("Beth");
        set.add("Alex");
        set.add("Charlie");
        System.out.println(set);
    }
}
