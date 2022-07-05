package com.budai.annotation.bean.config;

import com.budai.annotation.bean.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestConfig {

    /**
     * @Bean 未指定 name 时默认 bean 的值为方法名
     */
    @Bean(name = "user")
    @Scope("prototype")
    public User TestBean() {
        return new User();
    }
}
