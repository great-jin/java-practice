package basis.exception;

import org.junit.Test;

public class ExceptTest {

    /**
     * "printStackTrace()" will print the error, and carry out last code
     */
    @Test
    public void ExceptionDemo() {
        try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("This is will show");
    }

    @Test
    public void Exception1Demo() {
        try {
            Integer.parseInt("abc");
        } catch (Exception e) {
        }

        System.out.println("This is will show.");
    }

    /**
     * "throw new" will break code running, last command not be executed.
     * It also will throw exception to the father( Use it class or method ).
     */
    @Test
    public void Exception2Demo() {
        try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        System.out.println("This is will not show.");
    }
}
