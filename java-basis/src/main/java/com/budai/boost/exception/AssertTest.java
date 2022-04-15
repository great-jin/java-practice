package com.budai.boost.exception;

import org.junit.Test;
import org.springframework.util.Assert;

public class AssertTest {

    @Test
    public void AssertDemo() {
        String msg = "";

        Assert.hasLength(msg, "不允许为空");
    }
}
