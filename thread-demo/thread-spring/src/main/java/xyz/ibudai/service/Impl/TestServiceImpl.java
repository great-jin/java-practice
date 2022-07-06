package xyz.ibudai.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import xyz.ibudai.service.TestService;

import java.util.concurrent.Future;

@Service
public class TestServiceImpl implements TestService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Async
    @Override
    public Future<String> myTask() {
        taskExecutor.submit(() -> {
            logger.info("任务 1");
        });
        return new AsyncResult<>("任务 1 执行完成");
    }

    @Async
    @Override
    public Future<String> myTask1() {
        taskExecutor.submit(() -> {
            logger.info("任务 2");
        });
        return new AsyncResult<>("任务 2 执行完成");
    }
}
