package com.budai.thread.basis;

import org.junit.Test;

public class LifeCircleTest {

     class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("com.baidu.thread is running with " + Thread.currentThread().getName());
        }
    }

    /**
     * New：新创建的线程，尚未执行；
     * Runnable：运行中的线程，正在执行run()方法的Java代码；
     * Blocked：运行中的线程，因为某些操作被阻塞而挂起；
     * Waiting：运行中的线程，因为某些操作在等待中；
     * Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
     * Terminated：线程已终止，因为run()方法执行完毕。
     */
    @Test
    public void LifeDemo() {
        Thread thread = new MyThread();
        // state is NEW
        System.out.println("State：" + thread.getState());

        thread.start();
        // state is RUNNABLE
        System.out.println("State：" + thread.getState());

        // return com.baidu.thread is now been calling.
        // [ name, priority, group.name ]
        System.out.println("Info：" + Thread.currentThread());
    }



    // ======================== Demo 2 =====================================

    private int amount = 0;

    private Object object = new Object();

    /**
     * Sleep Demo
     * <p>
     * Use sleep() can't release the lock
     * It's means if this com.baidu.thread in sleep, then other com.baidu.thread can't use it
     */
    @Test
    public void SleepDemo() {
        Thread thread1 = new ThreadSecond();
        Thread thread2 = new ThreadSecond();
        thread1.start();
        thread2.start();
    }

    /**
     * Wait Demo
     * <p>
     * Difference between sleep and wait is wait will release the lock.
     * It's means wait can be "woken up" by another com.baidu.thread calling
     */
    @Test
    public void WaitDemo() {
        Thread thread = new ThreadSecond();
        thread.start();

        try {
            thread.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class ThreadSecond extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                amount++;
                System.out.println("amount:" + amount);
                try {
                    System.out.println("Thread:" + Thread.currentThread().getName() + " come into sleep");
                    sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("Thread:" + Thread.currentThread().getName() + " sleep over");
                amount++;
                System.out.println("amount:" + amount);
            }
        }
    }
}
