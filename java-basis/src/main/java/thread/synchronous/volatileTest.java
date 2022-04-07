package thread.synchronous;

import org.junit.Test;

public class volatileTest {

    /**
     * Use volatile declare variable was store in main memory
     * It means other thread only through main memory can get values
     */
    @Test
    public void VolatileDemo() throws InterruptedException {
        Thread addVolatile = new AddVolatileThread();
        Thread decVolatile = new DecVolatileThread();
        addVolatile.start();
        decVolatile.start();
        addVolatile.join();
        decVolatile.join();

        System.out.println(Counter.countVolatile);
    }

}


/**
 * Volatile make variable visible for multiple thread
 */
class AddVolatileThread extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (Counter.lock) {
                Counter.countVolatile += 1;
            }
        }
    }
}

class DecVolatileThread extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (Counter.lock) {
                Counter.countVolatile -= 1;
            }
        }
    }
}