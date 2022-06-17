package thread.single.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static Lock lock = new ReentrantLock();
    private int count;

    @Test
    public void LockDemo() {
        Thread thread1 = new AddThread();
        Thread thread2 = new DecThread();
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }

    class AddThread extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10000; i++) {
                    count += 1;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    class DecThread extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10000; i++) {
                    count -= 1;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}





