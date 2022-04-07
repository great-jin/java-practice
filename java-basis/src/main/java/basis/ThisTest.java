package basis;

import org.junit.Test;

public class ThisTest {

    int num = 1024; // An instance variable

    static int staticNum = 4096; // An instance variable

    @Test
    public void ThisDemo() {
        print1(2048);

        print2(2048);
    }

    /**
     * When local variable and instance variable with same name
     * "this" represented the instance variable
     */
    public void print1(int num) {
        System.out.println("Parameter num: " + num);
        System.out.println("Instance variable num: " + this.num);
    }

    /**
     * The static method didn't have "this" key word.
     *
     * The static method want visit whole scale variable need to make variable "static"
     */
    public static void print2(int num) {
        // It is illegal for "this.num"

        System.out.println("Parameter num: " + num);
        System.out.println("Parameter num: " + ThisTest.staticNum);
    }

}
