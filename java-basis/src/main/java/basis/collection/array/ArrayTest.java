package basis.collection.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        List<String> list = Arrays.asList(str);
        StringBuilder builder = new StringBuilder();
        list.forEach(s -> {
            builder.append(s).append(",");
        });
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder);
    }
}
