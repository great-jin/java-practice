package thread.pool;

import org.junit.Test;

import java.util.concurrent.*;

public class FutureTest {

    class MyTask implements Callable {

        @Override
        public String call(){
            return "1323";
        }
    }

    /**
     * Future<T>: a result that may be returned in the future
     */
    @Test
    public void FutureDemo() {
        ExecutorService executor = Executors.newCachedThreadPool();
        // 定义任务:
        Callable<String> task = new MyTask();
        // 提交任务并获得Future:
        Future<String> future = executor.submit(task);

        boolean state= false;
        boolean cancel= false;
        String result1 = null;
        String result2 = null;
        try {
            // judge the thread task is done or not.
            state = future.isDone();
            // cancel current task
            cancel = future.cancel(true);

            // may block
            result1 = future.get();
            // waiting 100 second and get result, may block
            result2 = future.get(100, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(state);
        System.out.println(cancel);
    }
}
