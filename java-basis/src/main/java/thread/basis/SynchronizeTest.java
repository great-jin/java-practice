package thread.basis;

public class SynchronizeTest {

    private int count = 0;

    public synchronized void add_1(int n) { // 锁住this
        count += n;
    } // 解锁

    /**
     * The below code have same effecting with above
     */
    public void add_1_1(int n) {
        synchronized (this) { // 锁住this
            count += n;
        } // 解锁
    }


    // =========================== Demo 2 ==================================

    /**
     * "static" didn't have "this" key word
     */
    public synchronized static void add_2(int n) {
        // do something

    }

    /**
     * The below code have same effecting with above
     */
    public static void add_2_1(int n) {
        synchronized (SynchronizeTest.class) {
            // do something
        }
    }


    // =========================== Demo 3 ==================================

    /**
     * The lock can repeatedly get by same com.baidu.thread.
     * <p>
     * When "add_5()" execute, "this" will be lock, if n<0 than "dec_5()" will get lock again.
     */
    public synchronized void add_3(int n) {
        if (n < 0) {
            dec_3(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec_3(int n) {
        count += n;
    }


    // =========================== Demo 4 ==================================

    /**
     * Although lock can be repeated get by same com.baidu.thread, but we need to record the number of time lock be get.
     * <p>
     * When the count be 0 we need to close com.baidu.thread
     */
    int value;

    public synchronized void add_4(int n) {
        this.value++;
        if (n < 0) {
            dec_4(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec_4(int n) {
        this.value--;
        count += n;
    }

}
