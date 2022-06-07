package com.budai.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ThreadTest {

    @Autowired
    @Qualifier(value = "taskExecutor")
    private ThreadPoolTaskExecutor taskExecutor;

}
