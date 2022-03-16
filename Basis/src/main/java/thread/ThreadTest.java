package thread;

import org.junit.Test;

public class ThreadTest {

    /**
     * The major difference is if you use extend to create a thread, then you can't to extend other classes
     * But when you use Runnable interface to create a thread, you can also to extends other class
     *
     * For example:
     * You can use "public class Test extends AbstractTest implements Runnable {}" to declare a class,
     * But you can't use "public class Test extends Thread, OtherClass",
     * It is illegal for extends multiple classes.
     */
    @Test
    public void DeclareDemo(){
        ThreadExtend threadExtend = new ThreadExtend();
        threadExtend.start();

        Thread thread = new Thread(new ThreadImpl());
        thread.start();
    }


    /**
     * There is two difference way create a Thread
     * 1. Through Extends "Thread" Class and override the "run()"
     * 2. Through implements "Runnable" Interface and override the "run()"
     */

    class ThreadExtend extends Thread{
        @Override
        public void run() {
            System.out.println("Through extends \"Thread\" Class and override the \"run()\"!");
        }
    }

    class ThreadImpl implements Runnable{
        @Override
        public void run() {
            System.out.println("Through implements \"Runnable\" Interface and override the \"run()\"!");
        }
    }

}
