package thread.pool;

import org.junit.Test;

import java.util.concurrent.*;

public class FutureTest {

    class MyTask implements Callable<String> {
        @Override
        public String call() {
            return "message";
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("message");
        }
    }

    /**
     * Future<T>: a result that may be returned in the future
     */
    @Test
    public void FutureDemo() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<String> task = new MyTask();
        // 提交任务并获得Future:
        Future<String> future = executor.submit(task);

        String result1 = "", result2 = "";
        boolean state = false, cancel = false;
        try {
            // judge the thread task is done or not.
            state = future.isDone();
            // cancel current task
//            cancel = future.cancel(true);

            // may block
            result1 = future.get();
            // waiting 100 second and get result, may block
            result2 = future.get(100, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            // time need to release lock
            e.printStackTrace();
        }

        System.out.println("state: " + state);
        System.out.println("cancel: " + cancel);
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
    }


    @Test
    public void demo() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(new MyThread());
        Object result = new Object();
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }
}
