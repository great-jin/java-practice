package thread.synchronous;

public class BasisTest {

    private int count = 0;

    public synchronized void add1(int n) { // 锁住this
        count += n;
    } // 解锁

    /*
    // The below code have same effection with above

    public void add1(int n) {
        synchronized(this) { // 锁住this
            count += n;
        } // 解锁
    }
    */


    /**
     * static didn't have this "key" word
     */
    public synchronized static void add2(int n) {
        // do something
    }

    /*
    // The below code have same effection with above

    public static void add2(int n) {
        synchronized(BasisTest.class) {
            // do something
        }
    }
    */

    /**
     * The lock can repeatedly get by same thread.
     *
     * When "add3()" execute, "this" will be lock, if n<0 than "dec3()" will get lock again.
     */
    public synchronized void add3(int n) {
        if (n < 0) {
            dec3(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec3(int n) {
        count += n;
    }

    /**
     * Although lock can be repeated get by same thread, but we need to record the number of time lock be get.
     *
     * When the count be 0 we need to close thread
     */
    int value;

    public synchronized void add4(int n) {
        this.value ++;
        if (n < 0) {
            dec4(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec4(int n) {
        this.value --;
        count += n;
    }

}
