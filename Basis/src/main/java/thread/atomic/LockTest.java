package thread.atomic;

import org.junit.Test;

public class LockTest {

    @Test
    public void LockDemo() throws InterruptedException {
        Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();

        System.out.println(Counter.count);
    }

}

class Counter {
    public static final Object lock = new Object();
    public static int count = 0;
}

/**
 * "synchronized" make sure that the code only can be executed by one thread in the same time
 *  But it's also will cost performance, and the code can't be currency
 *  Whatever code right or wrong, it's always release lock when command finish
 *
 */
class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            // to get lock
            synchronized (Counter.lock) {
                Counter.count += 1;
            }
            // when code finished, the lock will auto released.
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            // only when the object not been lock can run below command
            synchronized (Counter.lock) {
                Counter.count -= 1;
            }
        }
    }
}
