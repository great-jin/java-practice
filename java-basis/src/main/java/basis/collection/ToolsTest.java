package basis.collection;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ToolsTest {

    /**
     * Google 字符串工具包
     */
    @Test
    public void GoogleStrUtils() {
        String str = "";
        if (Strings.isNullOrEmpty(str)) {
            System.out.println("String is null");
        }
    }

    /**
     * Google 集合工具包
     */
    @Test
    public void GoogleCollTools() {
        List<String> list1 = new ArrayList<>();
        list1.add("AA");
        list1.add("BB");
        list1.add("CC");
        Set<String> sets1 = Sets.newHashSet(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("AA");
        list2.add("BB");
        Set<String> sets2 = Sets.newHashSet(list2);

        // 交集
        Sets.SetView<String> intersection = Sets.intersection(sets1, sets2);
        System.out.println("交集为： " + intersection);

        // 差集
        Sets.SetView<String> diff = Sets.difference(sets1, sets2);
        System.out.println("差集为： " + diff);

        // 并集
        Sets.SetView<String> union = Sets.union(sets1, sets2);
        System.out.println("并集为： " + union);
    }


    /**
     * HuTool 字符串工具包
     */
    @Test
    public void HuToolStrUtils() {
        String str = "";
        if (StrUtil.isBlank(str)) {
            System.out.println("String is null");
        }
    }

    /**
     * HuTool 集合封装工具包
     */
    @Test
    public void HuToolColl() {
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
}
