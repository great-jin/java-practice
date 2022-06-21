package basis.collection.array;

import java.util.*;

import basis.bean.User;
import com.sun.deploy.util.StringUtils;
import org.junit.Test;

public class ListTest {

    /**
     * 实现高效的动态增减元素
     * 按照存入的顺序进行存放，允许重复元素
     * List 不能直接实例化对象，List list = new List(); 是非法的。
     */
    @Test
    public void ListDemo() {
        List<String> list = new ArrayList<>();
        list.add("Jack");
        list.add("Mark");
        list.add("Beth");
        // 允许重复元素
        list.add("Beth");

        System.out.println(list);
        System.out.println(list.size());
    }

    /**
     * 链表，增删相对效率更高
     * 可以在任意位置进行高效插入删除
     */
    @Test
    public void LinkedListDemo() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Alex");
        System.out.println(list);

        // 操作头
        list.addFirst("Jack");
        list.removeFirst();

        // 操作尾
        list.addLast("Beth");
        list.removeLast();

        System.out.println(list);
    }
}
