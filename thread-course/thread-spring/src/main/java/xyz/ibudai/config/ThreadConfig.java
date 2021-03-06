package xyz.ibudai.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadConfig {

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数，未设置默认为 0，在创建了线程池后，当提交任务后就会创建一个线程去执行任务
        executor.setCorePoolSize(5);
        // 最大线程数，当线程数量大于等于 maxPoolSize 后，开始使用拒绝策略拒绝
        executor.setMaxPoolSize(30);
        // 缓冲队列大小，当线程数目达到 corePoolSize 后，就会把到达的任务放到缓存队列，当队列满了新建线程
        executor.setQueueCapacity(10000);
        // 允许线程空闲时间（单位：默认为秒）
        executor.setKeepAliveSeconds(30);
        // 线程池名前缀
        executor.setThreadNamePrefix("ibudai-thread");
        // 线程池对拒绝任务的处理策略
        // CallerRunsPolicy：由调用线程（提交任务的线程）处理该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }
}
