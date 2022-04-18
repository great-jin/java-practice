package thread.basis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WaitNotifyTest {

    @Test
    public void Demo() {
        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread() {
                public void run() {
                    // 执行task:
                    while (true) {
                        String s = q.getTask();
                        System.out.println("execute task: " + s);
                    }
                }
            };
            t.start();
            ts.add(t);
        }
        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
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
        for (Thread t : ts) {
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
