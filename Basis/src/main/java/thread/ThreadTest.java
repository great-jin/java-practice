package thread;

import org.junit.Test;

public class ThreadTest {

    /**
     * There is two difference way create a Thread
     * 1. Through Extends "Thread" Class and override the "run" method
     * 2. Through implements "Runnable" Interface and override the "run" method
     */

    @Test
    public void ExtendDemo(){
        ThreadExtend thread = new ThreadExtend();
        thread.start();
    }

    @Test
    public void RunnableDemo(){
        ThreadImpl object = new ThreadImpl();
        Thread thread = new Thread(object);
        thread.start();
    }


    /**
     * The major difference between it is if you use extend to create a thread, then you can't to extend other classes
     * But when you use Runnable interface to create a thread, you can also to extends other class
     *
     * For example:
     * You can use "public class Test extends AbstractTest implements Runnable {}" to declare a class,
     * But you can't use "public class Test extends Thread, OtherClass",
     * It is illegal for extends multiple classes.
     */

    class ThreadExtend extends Thread{
        @Override
        public void run() {
            System.out.println("running in Thread thread!");
        }
    }

    class ThreadImpl implements Runnable{
        @Override
        public void run() {
            System.out.println("running in Runnable thread!");
        }
    }

}
