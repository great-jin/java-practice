package thread.basis;

import org.junit.Test;

public class interruptTest {

    /**
     * When thread receive "interrupt()" than it will stop execute "run()"
     */
    @Test
    public void InterruptDemo() {
        Thread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(1); // 暂停1毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * join() will make thread into wait, and interrupt make thread quit
         * When before "join" to use "interrupt" the join() will throw exception
         * and the thread will stop
         */
        thread.interrupt(); // 中断t线程
        try {
            thread.join(); // 等待t线程结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }

    @Test
    public void volatileDemo() {
        TagThread t = new TagThread();
        t.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false; // 标志位置为false
    }
}


/**
 * To detect thread is interrupted, if interrupt than stop running.
 */
class MyThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
        }
    }
}


/**
 * In JVM, the variable was store in the main memory, when a thread want to change a variable,
 * it needed to read from main memory and change it, than it needed to write new value to memory
 * But before it to rewrite, the main memory value still no change, and other thread will get the old value
 * <p>
 * volatile make sure the variable change and rewrite to the memory immediately.
 * It means the variable is visible for multiple thread.
 */
class TagThread extends Thread {
    public volatile boolean running = true;

    @Override
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " hello!");
        }

        System.out.println("end!");
    }
}