package com.budai.anno.config;

import com.budai.anno.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestConfig {

    /**
     * @Bean 未指定 name 时默认值为方法名
     */
    @Bean
    //    @Bean(name = "user")
    @Scope("prototype")
    public User TestBean() {
        return new User();
    }
}
