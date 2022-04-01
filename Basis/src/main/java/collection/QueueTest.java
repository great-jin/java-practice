package collection;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    @Test
    public void QueueDemo() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);

        queue.add(3);
        queue.add(4);

        System.out.println(queue);

        // 打印队头并删除
        // 在容量为0的时候，remove()会抛出异常，poll()返回false
        System.out.println(queue.poll());
        System.out.println(queue.remove());
        System.out.println(queue);

        // 仅打印不删除
        // 容量为0的时候，element()会抛出异常，peek()返回null。
        System.out.println(queue.peek());
        System.out.println(queue.element());
        System.out.println(queue);
    }
}
