package thread;

import org.junit.Test;

public class LifeCircleTest {

    private int amount = 0;

    private Object object = new Object();

    class ThreadSon extends Thread{
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

    /**
     * Sleep Demo
     */
    @Test
    public void SleepDemo(){
        ThreadSon thread1 = new ThreadSon();
        ThreadSon thread2 = new ThreadSon();
        thread1.start();
        thread2.start();
    }

    /**
     * Wait Demo
     */
    @Test
    public void WaitDemo(){
        ThreadSon thread = new ThreadSon();
        thread.start();
        try {
            thread.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
