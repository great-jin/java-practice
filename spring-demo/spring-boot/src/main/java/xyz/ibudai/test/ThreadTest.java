package xyz.ibudai.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ThreadTest {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

}
