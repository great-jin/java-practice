package upgrade.collection.array;

import org.junit.Test;

import java.util.*;

public class QueueTest {

    @Test
    public void QueueDemo() {
        Queue<Integer> queue = new LinkedList<>();

        // insert element
        // When capacity overflow than "add()" throw exception, but "offer()" return false
        queue.add(1);
        queue.offer(2);
        System.out.println(queue);
        System.out.println(queue.size());

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

    /**
     * The queue will compare the ASCII values to set priority
     */
    @Test
    public void PriorityDemo() {
        Queue<String> queue = new PriorityQueue<>();
        queue.offer("apple");
        queue.offer("pear");
        queue.offer("banana");

        while(queue.size()>0){
            System.out.println(queue.poll());
        }
    }

    /**
     * The Dequeue can insert and remove element from both side.
     */
    @Test
    public void DequeueDemo() {
        Deque<Integer> queue = new LinkedList<>();

        // insert from both side
        queue.addFirst(1);
        queue.addLast(2);
        queue.offerFirst(3);
        queue.offerLast(4);

        // visit element
        System.out.println(queue.peekFirst());
        System.out.println(queue.peekLast());
        System.out.println(queue.element());

        // remove from both side
        queue.pollFirst();
        queue.pollLast();
        queue.removeFirst();
        queue.removeFirst();
    }
}
