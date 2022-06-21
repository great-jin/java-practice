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

        List<String> list2 = new ArrayList<>();
        list2.add("AA");
        list2.add("DD");

        // 去重
        Collection<String> distinct = CollectionUtil.distinct(list1);
        System.out.println("list1 distinct: " + distinct);

        // 去交集
        Collection<String> subtract = CollectionUtil.subtract(list1, list2);
        System.out.println("list1 remove list2: " + subtract);

        // 求交集
        Collection<String> intersection = CollectionUtil.intersection(list1, list2);
        System.out.println("list1 same element with list2: " + intersection);

        // 去交集, 更新原集合
        list1.removeAll(list2);
        System.out.println("list1 removeAll list2: " + list1);
    }
}
