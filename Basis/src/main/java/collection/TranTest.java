package collection;

import cn.hutool.json.JSONObject;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TranTest {

    /**
     * List转Set，从而实现去重
     * 两种方案：
     *          Set<String> set = new HashSet<>(list);
     *          Set<String> set = list.stream().collect(Collectors.toSet());
     */
    @Test
    public void LisToSetDemo() {
        List<String> list = new ArrayList<>();
        list.add("Alex");
        list.add("Blob");
        list.add("Blob");
        list.add("Mark");

        Set<String> set1 = new HashSet<>(list);
        System.out.println(set1);

        Set<String> set2 = list.stream().collect(Collectors.toSet());
        System.out.println(set2);
    }


    /**
     * Map与Json格式转化
     */
    @Test
    public void TransDemo(){
        Map<Integer, String> map = new Hashtable<>();
        map.put(1, "Alex");
        map.put(2, "Bob");

        System.out.println(new JSONObject(map));
    }

}
