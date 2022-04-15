package thread.basis;

import org.junit.Test;

import java.time.LocalTime;

public class LifeCircleTest {

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
        Thread thread = new ThreadSon();
        // state is NEW
        System.out.println("State：" + thread.getState());

        thread.start();
        // state is RUNNABLE
        System.out.println("State：" + thread.getState());

        // return thread is now been calling.
        // [ name, priority, group.name ]
        System.out.println("Info：" + Thread.currentThread());
    }

    /**
     * set none stop task in daemon, when none daemon thread finish,
     * then JVM will auto stop daemon thread, it won't cost resource waste.
     */
    @Test
    public void DaemonDemo() {
        System.out.println("main: start.");
        Thread thread = new TimerThread();
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        System.out.println("main: end.");
    }
}


class ThreadSon extends Thread {
    @Override
    public void run() {
        System.out.println("thread is running with " + Thread.currentThread().getName());
    }
}

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
