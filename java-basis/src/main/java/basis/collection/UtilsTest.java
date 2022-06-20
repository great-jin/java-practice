package basis.collection;

import java.util.*;

import basis.bean.User;
import org.junit.Test;
import cn.hutool.json.JSONObject;
import cn.hutool.core.collection.CollectionUtil;

public class UtilsTest {

    /**
     * 遍历集合
     */
    @Test
    public void IterateDemo() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        // 利用迭代器遍历集合
        Iterator<String> iter = list.iterator();
        // iter.previous()
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // 效果同迭代器遍历，更常用
        for (String str : list) {
            System.out.println(str);
        }

        // 使用 lambda 表达式遍历
        list.forEach(str -> {
            System.out.println(str);
        });
    }

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
     * List 转 Set，从而实现去重
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
    }

    /**
     * 求出 Map 中 Key 最大值
     */
    @Test
    public void getMaxKey() {
        Map<Integer, String> testMaps = new HashMap<>();
        testMaps.put(1, "Alex");
        testMaps.put(2, "Bob");
        testMaps.put(3, "Beth");
        // 获取所有 Key 值
        Set<Integer> keySet = testMaps.keySet();

        System.out.println(Collections.max(keySet));
    }

    /**
     * Map 与 Json 格式转化
     */
    @Test
    public void MapToJsonDemo() {
        Map<Integer, String> map = new Hashtable<>();
        map.put(1, "Alex");
        map.put(2, "Blob");

        System.out.println(new JSONObject(map));
    }

    /**
     * 集合封装工具包
     */
    @Test
    public void UtilsDemo() {
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
        boolean isContains = CollectionUtil.contains(list1, "BB");
        System.out.println("list1 contains BB: " + isContains);


        List<String> list2 = new ArrayList<>();
        list2.add("AA");
        list2.add("DD");
        System.out.println("list2: " + list2);

        // 去除交集
        Collection<String> subtract = CollectionUtil.subtract(list1, list2);
        System.out.println("list1 remove list2: " + subtract);
        // 去除交集, 更新原集合
        list1.removeAll(list2);
        System.out.println(list1);

        // 求交集
        Collection<String> intersection = CollectionUtil.intersection(list1, list2);
        System.out.println("list1 same part list2: " + intersection);
    }

    @Test
    public void demo1() {
        List list = new ArrayList();
        list.add(new User("Alex", 28));
        list.add(new User("Beth", 14));
        list.add(new User("Mark", 45));
        list.sort(Comparator.comparing(User::getAge));

        list.forEach(record -> {
            System.out.println(record.toString());
        });
    }
}
