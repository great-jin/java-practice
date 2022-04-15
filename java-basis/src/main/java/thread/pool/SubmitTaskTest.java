package thread.pool;

import org.junit.Test;

import java.util.concurrent.*;

public class SubmitTaskTest {

    /**
     * The "submit" return an object can be visited in the future.
     */
    @Test
    public void CachedPoolDemo() {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(() -> {
            System.out.println("hello");
        });

        executor.shutdown();
    }
}


class Task implements Runnable {
    public String result;

    public void run() {
        this.result = longTimeCalculation();
    }
}
