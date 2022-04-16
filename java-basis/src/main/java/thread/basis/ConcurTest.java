package thread.basis;

import org.junit.Test;

public class ConcurTest {

    private int amount = 0;

    class ThreadSon extends Thread {
        @Override
        public void run() {
            amount++;
        }
    }

    /**
     * To detect com.baidu.thread is interrupted, if interrupt than stop running.
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


    @Test
    public void ConcurDemo() {
        Thread thread = new ThreadSon();
        thread.start();
        System.out.println("After com.baidu.thread start: " + amount);

        /**
         * The amount in com.baidu.thread may not finish, but below "amount++" may run first.
         * In logical after below command the "amount" value suppose be "2".
         * But actually the "amount" value is "1".
         * We don't know sure value of "amount"
         */
        amount++;
        System.out.println("After com.baidu.thread start and do add: " + amount);
    }

    /**
     * User "isAlive()" to avoid concurrent issue
     */
    @Test
    public void AliveDemo() {
        Thread thread = new ThreadSon();
        thread.start();
        // Only when com.baidu.thread stop can stop the loop.
        while (thread.isAlive()) {
            System.out.println("Waiting com.baidu.thread over ···");
        }
        System.out.println("After com.baidu.thread：" + amount);

        amount++;
        System.out.println("After com.baidu.thread do add：" + amount);
    }

    /**
     * Join: will wait for the com.baidu.thread activity stop then carry out next command
     */
    @Test
    public void JoinDemo() {
        Thread thread = new ThreadSon();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After com.baidu.thread：" + amount);

        amount++;
        System.out.println("After com.baidu.thread do add：" + amount);
    }

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
         * join() will make com.baidu.thread into wait, and interrupt make com.baidu.thread quit
         * When before "join" to use "interrupt" the join() will throw exception
         * and the com.baidu.thread will stop
         */
        thread.interrupt(); // 中断t线程
        try {
            thread.join(); // 等待t线程结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }
}
