package thread;

import org.junit.Test;

public class LifeCircleTest {

    private int amount = 0;
    private Object object = new Object();

    /**
     *
     */
    @Test
    public void SleepDemo(){
        ThreadTwo thread1 = new ThreadTwo();
        ThreadTwo thread2 = new ThreadTwo();
        thread1.start();
        thread2.start();
    }

    /**
     *
     */
    @Test
    public void WaitDemo(){
        ThreadTwo thread = new ThreadTwo();
        thread.start();
        try {
            thread.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @Test
    public void StopDemo(){
        ThreadTwo thread = new ThreadTwo();
        thread.start();
        thread.stop();
    }


    class ThreadTwo extends Thread{
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
