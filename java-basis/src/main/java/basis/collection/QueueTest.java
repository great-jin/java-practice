package basis.collection;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    /**
     * add(): When capacity overflow than throw exception
     *
     * offer(): When capacity overflow than return false
     */
    @Test
    public void QueueDemo() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue);

        // print front and delete
        // When capacity 0 than "remove()" will throw exception，
        // And "poll()" return "null"
        System.out.println(queue.poll());
        System.out.println(queue.remove());
        System.out.println(queue);

        // only do print
        // When capacity 0 than "element()" will throw exception，
        // And "peek()" return "null"
        System.out.println(queue.peek());
        System.out.println(queue.element());
        System.out.println(queue);
    }
}
