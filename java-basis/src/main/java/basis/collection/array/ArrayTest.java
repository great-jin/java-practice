package basis.collection.array;

import cn.hutool.core.collection.CollectionUtil;
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

    public static List<String> DiffTime(List<String[]> list1, List<String[]> list2) {
        List<String> time1 = new ArrayList<>();
        List<String> time2 = new ArrayList<>();
        list1.forEach(record -> {
            time1.add(record[0]);
        });
        list2.forEach(record -> {
            time2.add(record[0]);
        });
        // 获取接入方缺失时间段
        List<String> missDate = new ArrayList<>();
        if (time1.size() != time2.size()) {
            missDate.addAll(CollectionUtil.subtract(time1, time2));
        }
        // 去除缺失时间段，获取双方都包含的时间段
        List<String[]> bothDate = new ArrayList<>();
        list1.forEach(record -> {
            if (!missDate.contains(record[0])) {
                bothDate.add(record);
            }
        });
        // 获取数据量差异时间段
        int i = 0;
        while (i < bothDate.size()) {
            if (!list2.get(i)[1].equals(bothDate.get(i)[1])) {
                missDate.add(bothDate.get(i)[0]);
            }
            i++;
        }
        return missDate;
    }
}
