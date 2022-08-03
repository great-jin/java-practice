import org.junit.Test;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class InitialTest {

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

        TimeCall myCall = new TimeCall();
        Long info = myCall.call();
        System.out.println("call result: " + info);
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
     * set none stop task be "daemon", when other thread finish,
     * then JVM will auto stop daemon thread, it won't cost resource waste.
     */
    @Test
    public void DaemonDemo() {
        Thread thread = new TimerThread();
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }


    /**
     * 1. Through Extends "Thread" Class and override the "run()"
     * <p>
     * If you use extend to create a thread, then you can't to extend other classes
     */
    static class ThreadExtend extends Thread {
        @Override
        public void run() {
            System.out.println("Thread is running.");
        }
    }


    /**
     * 2. Through implements "Runnable" Interface and override the "run()"
     * <p>
     * when you use Runnable interface to create a thread, you can also to extends other class
     */
    static class ThreadImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable is running.");
        }
    }


    /**
     * 3. Through implements "Callable" Interface and override the "call()"
     * <p>
     * When you need thread return variable that you can use Callable
     */
    static class TimeCall implements Callable<Long> {
        @Override
        public Long call() {
            return System.currentTimeMillis();
        }
    }


    /**
     * 4. None stop thread
     */
    static class TimerThread extends Thread {
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
}

