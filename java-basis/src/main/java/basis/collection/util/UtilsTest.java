package basis.collection.util;

import java.util.*;

import bean.User;
import com.sun.deploy.util.StringUtils;
import org.junit.Test;
import cn.hutool.json.JSONObject;

public class UtilsTest {

    /**
     * List 列表元素合并
     */
    @Test
    public void ApacheStrUtils() {
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add("BB");
        list.add("CC");
        String result = StringUtils.join(list, ",");
        System.out.println(result);
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
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Alex");
        map.put(2, "Bob");
        map.put(3, "Beth");
        // 获取所有 Key 值
        Set<Integer> keySet = map.keySet();
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
     * 列表元素排序
     */
    @Test
    public void ListSort() {
        List<String> list = new ArrayList();
        list.add("Alex");
        list.add("Mark");
        list.add("Beth");

        Collections.sort(list);
        System.out.println(list);
    }

    /**
     * 列表动态元素排序
     */
    @Test
    public void DynamicSort() {
        List<User> list = new ArrayList();
        list.add(new User("Alex", 28));
        list.add(new User("Beth", 14));
        list.add(new User("Mark", 45));

        // 列表排序
        list.sort(Comparator.comparing(User::getAge));
        list.forEach(record -> {
            System.out.println(record.toString());
        });
    }
}
