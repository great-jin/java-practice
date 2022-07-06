package xyz.ibudai.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ibudai.service.TestService;

@RestController
@RequestMapping("thread")
public class ThreadTest {

    @Autowired
    private TestService testService;

    @GetMapping("task")
    public void Task() {
        testService.myTask();
        testService.myTask1();
    }
}
