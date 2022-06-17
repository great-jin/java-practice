package thread.single.lock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WaitTest {

    @Test
    public void Demo() {
        TaskQueue queue = new TaskQueue();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                // 执行task:
                while (true) {
                    String s = queue.getTask();
                    System.out.println("execute task: " + s);
                }
            });
            thread.start();
            threadList.add(thread);
        }
        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                queue.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });
        add.start();
        try {
            add.join();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Thread t : threadList) {
            t.interrupt();
        }
    }
}


/**
 * Blow method will cost dead loop
 */
class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {
            // code will jump into loop can't release lock
            // program will into a dead loop
        }
        return queue.remove();
    }
}


/**
 * "wait()" and "notify()" use case
 */
class TaskQueue1 {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);

        // "notify()" wake the "wait()"
        this.notify();
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {
            try {
                // when queue is empty, thread will wait
                // When wait be executed, it will release the lock
                this.wait();
                // release lock
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }
}
