package sql.utils;

import cn.hutool.core.collection.CollectionUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DiffTime {

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
