package com.budai.thread;

import org.junit.Test;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class CreateTest {

    /**
     * if you only need com.baidu.thread do simple task, you don't have to create a new class
     */
    @Test
    public void TaskDemo() {
        new Thread(() -> {
            // do somethings

            System.out.println("task demo!");
        }).start();
    }

    /**
     * You can like below code to declare a class:
     * " public class Test extends AbstractTest implements Runnable {} "
     * <p>
     * But you can't use "public class Test extends Thread, OtherClass",
     * It is illegal for extends multiple classes.
     */
    @Test
    public void DeclareDemo() {
        Thread threadExtend = new ThreadExtend();
        threadExtend.start();

        ThreadImpl myThread = new ThreadImpl();
        Thread thread = new Thread(myThread);
        thread.start();
    }

    /**
     * set none stop task in daemon, when none daemon com.baidu.thread finish,
     * then JVM will auto stop daemon com.baidu.thread, it won't cost resource waste.
     */
    @Test
    public void DaemonDemo() {
        System.out.println("main: start....");

        Thread thread = new TimerThread();
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("main: end....");
    }

    /**
     *
     */
    @Test
    public void CallDemo() {
        TimeCall1 thread = new TimeCall1();
        try {
            System.out.println(thread.call());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TimeCall2 thread2 = new TimeCall2();
        try {
            System.out.println(thread2.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * 1. Through Extends "Thread" Class and override the "run()"
 * <p>
 * If you use extend to create a com.baidu.thread, then you can't to extend other classes
 */
class ThreadExtend extends Thread {
    @Override
    public void run() {
        System.out.println("Through extends \"Thread\" Class and override the \"run()\"!");
    }
}


/**
 * 2. Through implements "Runnable" Interface and override the "run()"
 * <p>
 * when you use Runnable interface to create a com.baidu.thread, you can also to extends other class
 */
class ThreadImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("Through implements \"Runnable\" Interface and override the \"run()\"!");
    }
}

/**
 * 3. Through implements "Callable" Interface and override the "call()"
 * <p>
 * When you need com.baidu.thread return variable that you can use Callable
 */
class TimeCall1 implements Callable<Long> {
    @Override
    public Long call() {
        return System.currentTimeMillis();
    }
}

/**
 * You also can choose Callable not to set type
 * <p>
 * The effecting same with above.
 */
class TimeCall2 implements Callable {
    @Override
    public Long call() {
        return System.currentTimeMillis();
    }
}


/**
 * None stop com.baidu.thread
 */
class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            // 每隔 1 秒打印一次时间
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
