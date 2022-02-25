package thread;

import org.junit.Test;

public class ConcurTest {

    private int amount = 0;

    @Test
    public void ConcurDemo(){
        ThreadOne thread = new ThreadOne();
        thread.start();
        System.out.println(amount);

        amount++;
        System.out.println(amount);
    }

    /**
     * User isAlive() to avoid concurrent issue
     */
    @Test
    public void AliveDemo(){
        ThreadOne thread = new ThreadOne();
        thread.start();
        while(thread.isAlive()) {
            System.out.println("Waiting...");
        }

        // only when thread stop can execute below code
        System.out.println("Main: " + amount);

        amount++;
        System.out.println("Main: " + amount);
    }


    class ThreadOne extends Thread{
        @Override
        public void run() {
            amount ++;
        }
    }

}
