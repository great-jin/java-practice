import cn.hutool.core.collection.CollectionUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyTest {

    @Test
    public void demo1(){
        String[] str1 = {"path1", "path2", "path4", "path5"};
        String[] str2 = {"path1", "path2"};
        List<String> list1 = Arrays.stream(str1).collect(Collectors.toList());
        List<String> list2 = Arrays.stream(str2).collect(Collectors.toList());
        List<String> result = (List<String>) CollectionUtil.subtract(list1, list2);
        System.out.println(result);
    }

    @Test
    public void demo2(){
        List<List<String>> diffFiled = new ArrayList<>();
        diffFiled.add(new ArrayList<>());
        diffFiled.add(new ArrayList<>());

        String[] str1 = {"path1", "path2", "path4", "path5"};
        List<String> list1 = Arrays.stream(str1).collect(Collectors.toList());
        diffFiled.get(0).addAll(list1);

        System.out.println(diffFiled.get(0));;
        System.out.println(diffFiled);;
    }
}
