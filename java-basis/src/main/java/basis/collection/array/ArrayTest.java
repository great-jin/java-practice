package basis.collection.array;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSON;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayTest {

    @Test
    public void Demo() {
        // Set the fixed array size
        String[] st = new String[5];
        st[0] = "Hello";
        System.out.println(Arrays.toString(st));

        // Init the array size and content in definition
        // the size is "2", it's fixed
        String[] st1 = new String[]{"aa", "bb"};
        st1[1] = "cc";
        // out array index
        // st1[2] = "cc";
        System.out.println(Arrays.toString(st1));

        // Init the array size and content in definition
        // the size is "2", it's fixed
        String[] st2 = {"aa", "bb"};
        st2[1] = "cc";
        System.out.println(Arrays.toString(st2));
    }

    /**
     * Array to List
     */
    @Test
    public void ArrayToList() {
        String[] str = {"path1", "path2", "path3"};
        // In core the list still was array ,can't do any collection operate.
        List<String> list1 = Arrays.asList(str);
        // "add()" will go wrong.
        // list.add("path4");
        System.out.println(list1);

        // cast array to list
        List<String> list2 = Arrays.stream(str).collect(Collectors.toList());
        list2.add("path4");
        System.out.println(list2);
    }

    @Test
    public void DistinctDemo() {
        List<String[]> list1 = new ArrayList<>();
        list1.add(new String[]{"2022-06-07 17:00:00", "1"});
        list1.add(new String[]{"2022-06-08 14:00:00", "2"});
        list1.add(new String[]{"2022-06-09 17:00:00", "3"});
        list1.add(new String[]{"2022-06-10 18:00:00", "2"});
        list1.add(new String[]{"2022-06-16 11:00:00", "2"});

        List<String[]> list2 = new ArrayList<>();
        list2.add(new String[]{"2022-06-07 17:00:00", "1"});
        list2.add(new String[]{"2022-06-08 14:00:00", "2"});
        list2.add(new String[]{"2022-06-09 17:00:00", "1"});

        System.out.println(DiffTime(list1, list2));
    }

    private static List<String> DiffTime(List<String[]> list1, List<String[]> list2) {
        List<String> result = new ArrayList<>();
        List<String> time1 = new ArrayList<>();
        List<String> time2 = new ArrayList<>();
        list1.forEach(record -> {
            time1.add(record[0]);
        });
        list2.forEach(record -> {
            time2.add(record[0]);
        });
        if (time1.size() != time2.size()) {
            // 获取缺失时间段
            result.addAll(CollectionUtil.subtract(time1, time2));
        }
        List<String[]> list3 = new ArrayList<>();
        list1.forEach(record -> {
            if(!result.contains(record[0])){
                list3.add(record);
            }
        });
        int i = 0;
        while (i < list3.size()) {
            if (!list2.get(i)[1].equals(list3.get(i)[1])) {
                result.add(list3.get(i)[0]);
            }
            i++;
        }
        return result;
    }
}
