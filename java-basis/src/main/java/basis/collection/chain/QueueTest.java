package basis.collection.chain;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    @Test
    public void QueueDemo() {
        Queue<Integer> queue = new LinkedList<>();

        // insert element
        // When capacity overflow than "add()" throw exception, but "offer()" return false
        queue.add(1);
        queue.offer(2);
        System.out.println(queue);

        // remove element
        // When capacity zero than "remove()" throw exception, but "poll()" return "null"
        queue.poll();
        queue.remove();
        System.out.println(queue);

        // print element
        // When capacity 0 than "element()" throw exception，but "peek()" return "null"
        System.out.println(queue.peek());
        System.out.println(queue.element());
        System.out.println(queue);
    }
}
