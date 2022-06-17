package thread.single;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    @Test
    public void AtomicDemo() {
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.set(2);
        System.out.println("atomicInteger: " + atomicInteger);
        System.out.println("atomicInteger.get: " + atomicInteger.get());
        System.out.println("atomicInteger.get == 2: " + (atomicInteger.get() == 2));
        System.out.println("atomicInteger.incrementAndGet: " + atomicInteger.incrementAndGet());
        System.out.println("atomicInteger.decrementAndGet: " + atomicInteger.decrementAndGet());

        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        System.out.println("\natomicBoolean.origin: " + atomicBoolean);

        atomicBoolean.set(true);
        System.out.println("atomicBoolean.afterSet: " + atomicBoolean);
    }


    @Test
    public void volatileDemo() {
        VolatileThread thread = new VolatileThread();
        thread.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.running = false; // 标志位置为false
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
class VolatileThread extends Thread {

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

