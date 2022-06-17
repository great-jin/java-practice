package thread;

import org.junit.Test;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class CreateTest {

    /**
     * You can like below code to declare a class:
     * " public class Test extends AbstractTest implements Runnable {} "
     * <p>
     * But you can't use "public class Test extends Thread, OtherClass",
     * It is illegal for extends multiple classes.
     */
    @Test
    public void DeclareDemo() {
        Thread thread1 = new ThreadExtend();
        thread1.start();

        ThreadImpl myThread = new ThreadImpl();
        Thread thread2 = new Thread(myThread);
        thread2.start();
    }

    /**
     * if you only need thread do simple task, you can use lambda
     */
    @Test
    public void TaskDemo() {
        new Thread(() -> {
            // do somethings
            System.out.println("task demo!");
        }).start();
    }

    /**
     * set none stop task in daemon, when none daemon thread finish,
     * then JVM will auto stop daemon thread, it won't cost resource waste.
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
     * The thread with return variable
     */
    @Test
    public void CallDemo() {
        TimeCall1 thread = new TimeCall1();
        try {
            System.out.println(thread.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * 1. Through Extends "Thread" Class and override the "run()"
 * <p>
 * If you use extend to create a thread, then you can't to extend other classes
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
 * when you use Runnable interface to create a thread, you can also to extends other class
 */
class ThreadImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("Through implements \"Runnable\" Interface and override the \"run()\"!");
    }
}


/**
 * 3. None stop thread
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


/**
 * 4. Through implements "Callable" Interface and override the "call()"
 * <p>
 * When you need thread return variable that you can use Callable
 */
class TimeCall1 implements Callable<Long> {
    @Override
    public Long call() {
        return System.currentTimeMillis();
    }
}
