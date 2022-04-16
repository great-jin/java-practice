package thread.pool;

import org.junit.Test;

import java.util.concurrent.*;

public class SubmitTaskTest {

    /**
     * The "submit" return an object can be visited in the future.
     */
    @Test
    public void SubmitDemo() {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(() -> {
            System.out.println("hello");
        });

        executor.shutdown();
    }

    /**
     * Future<T>: a result that may be returned in the future
     */
    @Test
    public void FutureDemo() {
        ExecutorService executor = Executors.newCachedThreadPool();
        // 定义任务:
        Callable<String> task = new Task();
        // 提交任务并获得Future:
        Future<String> future = executor.submit(task);

        String result1 = null;
        String result2 = null;
        boolean state= false;
        boolean cancel= false;
        try {
            // may block
            result1 = future.get();
            // waiting 100 second and get result, may block
            result2 = future.get(100, TimeUnit.SECONDS);
            // judge the com.baidu.thread task is done or not.
            state = future.isDone();
            // cancel current task
            cancel = future.cancel(true);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(state);
        System.out.println(cancel);
    }
}


class Task implements Callable<String> {
    public String call() throws Exception {
        return "1323";
    }
}
