package thread.pool;

import org.junit.Test;

import java.util.concurrent.*;

public class SubmitTest {

    /**
     * The "submit" return an object can be visited in the future.
     */
    @Test
    public void SubmitDemo() {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(new MyThread());
        executor.shutdown();
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("task is running.");
    }
}
