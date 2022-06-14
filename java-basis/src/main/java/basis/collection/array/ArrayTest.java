package basis.collection.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
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
}
