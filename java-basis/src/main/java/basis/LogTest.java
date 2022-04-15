package basis;

import org.junit.Test;
import org.springframework.util.Assert;

public class LogTest {

    @Test
    public void LogDemo(){

    }

    @Test
    public void AssertDemo() {
        String msg = "";

        Assert.hasLength(msg, "不允许为空");
    }
}
