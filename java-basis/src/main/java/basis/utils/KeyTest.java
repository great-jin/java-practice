package basis.utils;

import org.junit.Test;

import java.util.Date;

public class KeyTest {

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
     * <p>
     * The static method want visit whole scale variable need to make variable "static"
     */
    public static void print2(int num) {
        // It is illegal for "this.num"

        System.out.println("Parameter num: " + num);
        System.out.println("Parameter num: " + KeyTest.staticNum);
    }

    /**
     * a instanceof B: 判断 a 是否为 b 的实例, 返回 Boolean
     */
    @Test
    public void InstanceDemo() {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());

        boolean b1 = utilDate instanceof java.sql.Date;
        System.out.println(b1);

        boolean b2 = sqlDate instanceof java.util.Date;
        System.out.println(b2);
    }
}
