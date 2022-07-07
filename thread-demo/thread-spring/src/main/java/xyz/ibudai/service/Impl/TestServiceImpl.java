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

    @Override
    public Future<String> Task() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            taskExecutor.submit(() -> {
                logger.info("任务 1 : " + finalI);
            });
        }
        return new AsyncResult<>("任务 1 执行完成");
    }

    @Override
    public Future<String> Task1() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            taskExecutor.submit(() -> {
                logger.info("任务 2 : " + finalI);
            });
        }
        return new AsyncResult<>("任务 2 执行完成");
    }


    @Override
    @Async("taskExecutor")
    public Future<String> Task3() {
        for (int i = 0; i < 5; i++) {
            logger.info("任务 3 : " + i);
        }
        return new AsyncResult<>("任务 3 执行完成");
    }

    @Override
    @Async("taskExecutor")
    public Future<String> Task4() {
        for (int i = 0; i < 5; i++) {
            logger.info("任务 4 : " + i);
        }
        return new AsyncResult<>("任务 4 执行完成");
    }
}
