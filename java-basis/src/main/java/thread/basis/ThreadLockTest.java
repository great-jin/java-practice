package thread.basis;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLockTest {

    public static final Object lock = new Object();

    public static int count = 0;
    public static int countLock = 0;
    public static AtomicInteger countAtomic = new AtomicInteger(0);

    /**
     * The below code every time the result was difference
     * The reason is when "dec" com.baidu.thread running, "add" com.baidu.thread may not finish
     * <p>
     * For example, the command "i++" com.baidu.basis mean three instruction for computer, "load", "add", "store",
     * In multiple com.baidu.thread ,when code was executed "load" or "add", it doesn't have store after add values to memory
     * it interrupted by other com.baidu.thread scheduling, that is the code come with difference result.
     */
    @Test
    public void UnLockDemo() throws InterruptedException {
        Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();

        add.join();
        dec.join();
        System.out.println(count);
    }

    /**
     * User lock only variable unlock other com.baidu.thread can use it.
     */
    @Test
    public void LockDemo() throws InterruptedException {
        Thread addLock = new AddLockThread();
        Thread decLock = new DecLockThread();
        addLock.start();
        decLock.start();

        addLock.join();
        decLock.join();
        System.out.println(countLock);
    }

    /**
     * The Atomic operate can't be interrupted by any com.baidu.thread scheduling
     */
    @Test
    public void AtomicDemo() throws InterruptedException {
        Thread addAtomic = new AddAtomicThread();
        Thread decAtomic = new DecAtomicThread();
        addAtomic.start();
        decAtomic.start();

        addAtomic.join();
        decAtomic.join();
        System.out.println(countLock);
    }


    // ===================== Thread class ==============================

    /**
     * Normal com.baidu.thread, it will cost variable unknowns
     */
    class AddThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                count += 1;
            }
        }
    }

    class DecThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                count -= 1;
            }
        }
    }


    /**
     * "synchronized" make sure that the code only can be executed by one com.baidu.thread in the same time
     * But it's also will cost performance, and the code can't be currency
     * Whatever code right or wrong, it's always release lock when command finish
     */
    class AddLockThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                // To get lock
                // Only when the object not been lock can run below command
                synchronized (lock) {
                    countLock += 1;
                }
            }
        }
    }

    class DecLockThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    countLock -= 1;
                }
            }
        }
    }


    /**
     * The Atomic provide safe operate can reach same result compare to  "synchronized"
     * And compare with "synchronized", it has better performance
     * <p>
     * The Atomic operate can't be interrupted by any com.baidu.thread scheduling
     * When it started, and is will run to finish
     */
    class AddAtomicThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                countAtomic.incrementAndGet();
            }
        }
    }

    class DecAtomicThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                countAtomic.decrementAndGet();
            }
        }
    }
}
