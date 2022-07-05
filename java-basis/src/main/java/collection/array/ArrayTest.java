package collection.array;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayTest {

    @Test
    public void Demo() {
        // Set the fixed array size
        String[] arr = new String[5];
        arr[0] = "Hello";
        System.out.println(Arrays.toString(arr));

        // Init the array size and content in definition
        // the size is fixed
        String[] st1 = {"aa", "bb"};
        String[] st2 = new String[]{"aa", "bb"};
        st1[1] = "cc";
        st2[1] = "cc";
        System.out.println(Arrays.toString(st1));
        System.out.println(Arrays.toString(st2));
    }

    /**
     * Array to List
     */
    @Test
    public void ArrayToList() {
        String[] str = {"path1", "path2", "path3"};
        // In core the list still was array ,can't do any collection operate.
        // "add()" etc operate will go wrong.
        List<String> list1 = Arrays.asList(str);
        System.out.println(list1);

        // cast array to list
        List<String> list2 = Arrays.stream(str).collect(Collectors.toList());
        list2.add("path4");
        System.out.println(list2);
    }
}
