import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyTest {
    public static void main(String[] args) {
        String[] str1 = {"path1", "path2", "path4", "path5"};
        String[] str2 = {"path1", "path2"};
        List<String> list1 = Arrays.stream(str1).collect(Collectors.toList());
        List<String> list2 = Arrays.stream(str2).collect(Collectors.toList());
        List<String> result = (List<String>) CollectionUtil.subtract(list1, list2);
        System.out.println(result);
    }
}
