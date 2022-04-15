package com.budai.thread.pool;

import org.junit.Test;

import java.util.concurrent.*;

public class CreatePoolTest {

    /**
     * create com.baidu.thread pool with specify of number
     */
    @Test
    public void FixedPoolDemo() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            executor.submit(new Task("" + i));
        }
        executor.shutdown();
    }

    /**
     * create com.baidu.thread pool that automatic with task number
     */
    @Test
    public void CachedPoolDemo() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            executor.submit(new Task("" + i));
        }
        executor.shutdown();

        /**
         * The com.baidu.thread connector number between min and max
         */
        int min = 4;
        int max = 10;
        ExecutorService es = new ThreadPoolExecutor(min, max,
                60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        es.shutdown();
    }

    /**
     * create com.baidu.thread pool for single com.baidu.thread
     */
    @Test
    public void SinglePoolDemo() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 6; i++) {
            executor.submit(new Task("" + i));
        }
        executor.shutdown();
    }

    /**
     * Create a schedule com.baidu.thread
     */
    @Test
    public void ScheduledPoolDemo() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        // execute after 1 second
        executor.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);

        // execute after 2 second, and repeat each 3 second
        // last task begin and after 3 second
        executor.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);

        // execute after 2 second, and repeat each 3 second
        // (after last task finish and 3 second)
        executor.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
        executor.shutdown();
    }


    /**
     * Task Thread
     */
    class Task implements Runnable {
        private final String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("start task " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("end task " + name);
        }
    }
}




