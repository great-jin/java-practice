package thread;

import org.junit.Test;

public class ConcurTest {

    private int amount = 0;

    class ThreadSon extends Thread{
        @Override
        public void run() {
            amount ++;
        }
    }


    @Test
    public void ConcurDemo(){
        ThreadSon thread = new ThreadSon();
        thread.start();
        System.out.println(amount);

        /**
         * The amount in thread may not finish, but below "amount++" may run first.
         * In logical after below command the "amount" value suppose be "2".
         * But actually the "amount" value is "1".
         * We don't know sure value of "amount"
         */
        amount++;
        System.out.println(amount);
    }

    /**
     * User "isAlive()" to avoid concurrent issue
     */
    @Test
    public void AliveDemo(){
        ThreadSon thread = new ThreadSon();
        thread.start();

        // Only when thread stop can stop the loop.
        while(thread.isAlive()) {
            System.out.println("Waiting...");
        }

        // When thread stop that below command can be executed.
        System.out.println("After thread main values: " + amount);

        amount++;
        System.out.println("After thread and add 1 main values: " + amount);
    }

}
