package encryption.sm;

import org.junit.Test;

import java.util.Arrays;

public class SMTest {

    private final String ORIGIN = "I am original information.";
    private final static String DEFAULT_KEY = "default-sm4-keys";

    @Test
    public void demo() {
        byte[] result = SM3Encryption.encode(ORIGIN);
        System.out.println(ORIGIN);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void demo1() {
        byte[] result1 = SM4Encryption.encode(DEFAULT_KEY, ORIGIN);
        String result2 = SM4Encryption.decode(DEFAULT_KEY, result1);

        System.out.println(ORIGIN);
        System.out.println(Arrays.toString(result1));
        System.out.println(result2);
    }
}
