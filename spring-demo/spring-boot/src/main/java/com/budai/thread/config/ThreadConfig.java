package com.budai.thread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
//@ConfigurationProperties(prefix = "task.pool")
public class ThreadConfig {

    /**
     * 核心线程数（默认线程数）
     * 若未设置默认为 0，在创建了线程池后，当提交任务后，就会创建一个线程去执行任务，
     */
    private static final int corePoolSize = 5;

    /**
     * 缓冲队列大小
     * 当线程池中的线程数目达到 corePoolSize 后，就会把到达的任务放到缓存队列，当队列满了新建线程
     */
    private static final int queueCapacity = 10000;

    /**
     * 最大线程数
     * 当线程数量大于等于 maxPoolSize 后，开始使用拒绝策略拒绝
     */
    private static final int maxPoolSize = 30;

    /**
     * 允许线程空闲时间（单位：默认为秒）
     */
    private static final int keepAliveTime = 30;

    /**
     * 线程池名前缀
     */
    private static final String threadNamePrefix = "ibudai-thread";

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadNamePrefix);

        // 线程池对拒绝任务的处理策略
        // CallerRunsPolicy：由调用线程（提交任务的线程）处理该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }
}
