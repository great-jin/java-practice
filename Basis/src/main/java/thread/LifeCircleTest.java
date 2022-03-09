package thread;

import org.junit.Test;

public class LifeCircleTest {

    private int amount = 0;

    private Object object = new Object();

    /**
     * New: the thread only be created, but no do anything.
     * Runnable: the thread ready to run or already in running.
     * Running: when thread get CPU resource then it changes to running state.
     */
    @Test
    public void LifeDemo(){
        ThreadSon thread = new ThreadSon();
        // state is new
        System.out.println("State：" + thread.getState());

        thread.start();
        // state is runnable
        System.out.println("State：" + thread.getState());

        // return thread is now been calling.
        // [ name, priority, group.name ]
        System.out.println("\nInfo：" + Thread.currentThread());
    }

    /**
     * run(): run constructor method and "run()" with main thread
     * start(): run constructor method with "main", run "run()" with child thread
     */
    @Test
    public void StartDemo(){
        ThreadFirst thread1 = new ThreadFirst();
        thread1.run();

        ThreadFirst thread2 = new ThreadFirst();
        thread2.start();
    }

    /**
     * Sleep Demo
     *
     * Use sleep() can't release the lock
     * It's means if this thread in sleep, then other thread can't use it
     */
    @Test
    public void SleepDemo(){
        ThreadSecond thread1 = new ThreadSecond();
        ThreadSecond thread2 = new ThreadSecond();
        thread1.start();
        thread2.start();
    }

    /**
     * Wait Demo
     *
     * Difference between sleep and wait is wait will release the lock.
     * It's means wait can be "woken up" by another thread calling
     */
    @Test
    public void WaitDemo(){
        ThreadSecond thread = new ThreadSecond();
        thread.start();

        try {
            thread.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    class ThreadSon extends Thread{
        @Override
        public void run() {
            System.out.println("thread is running with " + Thread.currentThread().getName());
        }
    }

    class ThreadFirst extends Thread{
        public ThreadFirst(){
            System.out.println("The contraction running with " + Thread.currentThread().getName());
        }

        @Override
        public void run() {
            System.out.println("thread is running with " + Thread.currentThread().getName());
        }
    }

    class ThreadSecond extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                amount ++;
                System.out.println("amount:" + amount);
                try {
                    System.out.println("Thread:" + Thread.currentThread().getName() + " come into sleep");
                    sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("Thread:" + Thread.currentThread().getName() + " sleep over");
                amount ++;
                System.out.println("amount:" + amount);
            }
        }
    }

}
