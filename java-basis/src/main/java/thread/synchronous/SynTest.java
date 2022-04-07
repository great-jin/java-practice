package thread.synchronous;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Without Lock when multiple thread use same variable, we can't know which thread was use variable
 * We don't know the code running process
 */
public class SynTest {

    /**
     * The below code every time the result was difference
     * The reason is when "dec" thread running, "add" thread may not finish
     * <p>
     * For example, the command "i++" basis mean three instruction for computer, "load", "add", "store",
     * In multiple thread ,when code was executed "load" or "add", it doesn't have store after add values to memory
     * it interrupted by other thread scheduling, that is the code come with difference result.
     */
    @Test
    public void UnLockDemo() throws InterruptedException {
        Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();

        add.join();
        dec.join();
        System.out.println(SynCounter.count);
    }

    /**
     * User lock only variable unlock other thread can use it.
     */
    @Test
    public void LockDemo() throws InterruptedException {
        Thread addLock = new AddLockThread();
        Thread decLock = new DecLockThread();
        addLock.start();
        decLock.start();

        addLock.join();
        decLock.join();
        System.out.println(SynCounter.countLock);
    }

    /**
     * The Atomic operate can't be interrupted by any thread scheduling
     */
    @Test
    public void AtomicDemo() throws InterruptedException {
        Thread addAtomic = new AddAtomicThread();
        Thread decAtomic = new DecAtomicThread();
        addAtomic.start();
        decAtomic.start();

        addAtomic.join();
        decAtomic.join();
        System.out.println(SynCounter.countLock);
    }

}

/**
 * Store result
 */
class SynCounter {
    public static final Object lock = new Object();

    public static int count = 0;
    public static int countLock = 0;
    public static volatile int countSyn = 0;
    public static AtomicInteger countAtomic = new AtomicInteger(0);
}


/**
 * Normal thread, it will cost variable unknowns
 */
class AddThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SynCounter.count += 1;
        }
    }
}

class DecThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SynCounter.count -= 1;
        }
    }
}


/**
 * "synchronized" make sure that the code only can be executed by one thread in the same time
 * But it's also will cost performance, and the code can't be currency
 * Whatever code right or wrong, it's always release lock when command finish
 */
class AddLockThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            // To get lock
            // Only when the object not been lock can run below command
            synchronized (SynCounter.lock) {
                SynCounter.countLock += 1;
            }
        }
    }
}

class DecLockThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (SynCounter.lock) {
                SynCounter.countLock -= 1;
            }
        }
    }
}


/**
 * The Atomic provide safe operate can reach same result compare to  "synchronized"
 * And compare with "synchronized", it has better performance
 * <p>
 * The Atomic operate can't be interrupted by any thread scheduling
 * When it started, and is will run to finish
 */
class AddAtomicThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SynCounter.countAtomic.incrementAndGet();
        }
    }
}

class DecAtomicThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SynCounter.countAtomic.decrementAndGet();
        }
    }
}
