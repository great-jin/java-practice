package collection;

import java.util.*;
import org.junit.Test;
import java.util.stream.Collectors;
import cn.hutool.json.JSONObject;
import cn.hutool.core.collection.CollectionUtil;

public class UtilsTest {

    /**
     * add() 只能单次存入一个实例
     * addALl 可以直接存入"集合"
     */
    @Test
    public void AddAllDemo() {
        List<String> list1 = new ArrayList<>();
        list1.add("Alex");
        list1.add("Beth");
        System.out.println(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("Mark");
        list2.addAll(list1);
        System.out.println(list2);
    }

    /**
     * List 和 Map 嵌套使用
     */
    @Test
    public  void Conbination() {
        List<Map<Integer, String>> list = new ArrayList<>();
        Map<Integer, String> set = new HashMap<Integer, String>();
        set.put(1, "Alex");
        set.put(2, "Bob");
        list.add(set);

        System.out.println(list);
    }

    /**
     * List转Set，从而实现去重
     * 两种方案：
     *          Set<String> set = new HashSet<>(list);
     *          Set<String> set = list.stream().collect(Collectors.toSet());
     */
    @Test
    public void ListToSetDemo() {
        List<String> list = new ArrayList<>();
        list.add("Alex");
        list.add("Blob");
        list.add("Blob");
        list.add("Mark");

        Set<String> set = new HashSet<>(list);
        System.out.println(set);

        Set<String> set2 = list.stream().collect(Collectors.toSet());
        System.out.println(set2);
    }

    /**
     * Map 与 Json 格式转化
     */
    @Test
    public void MapToJsonDemo(){
        Map<Integer, String> map = new Hashtable<>();
        map.put(1, "Alex");
        map.put(2, "Blob");

        System.out.println(new JSONObject(map));
    }

    /**
     * 集合封装工具包
     */
    @Test
    public void UtilsDemo(){
        List<String> list1 = new ArrayList<>();
        list1.add("AA");
        list1.add("AA");
        list1.add("BB");
        list1.add("CC");
        System.out.println("list1: " + list1);

        // 去除重复元素
        Collection<String> distinct = CollectionUtil.distinct(list1);
        System.out.println("list1 distinct: " + distinct);

        // 是否包含元素
        Boolean contains = CollectionUtil.contains(list1,"BB");
        System.out.println("list1 contains BB: " + contains);

        List<String> list2 = new ArrayList<>();
        list2.add("AA");
        list2.add("DD");
        System.out.println("list2: " + list2);

        // 去除交集
        Collection<String> subtract = CollectionUtil.subtract(list1, list2);
        System.out.println("list1 remove list2: " + subtract);

        // 求交集
        Collection<String> intersection = CollectionUtil.intersection(list1, list2);
        System.out.println("list1 same part list2: " + intersection);
    }

}
