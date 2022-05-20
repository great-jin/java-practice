package boost.exception;

import org.junit.Test;
import org.springframework.util.Assert;

public class AssertTest {

    /**
     * Basis use case
     */
    @Test
    public void AssertDemo() {
        /**
         * if error will throw an exception and last command not gone be executed
         */
        int y = -1;
        assert y > 0 : "y > 0";

        // defined the error information.
        int z = -1;
        assert z > 0 : "z > 0";
    }

    @Test
    public void Assert2Demo() {
        String msg = "";
        Assert.hasLength(msg, "不允许为空");
        // below won't be executed
        System.out.println("1111");
    }
}
