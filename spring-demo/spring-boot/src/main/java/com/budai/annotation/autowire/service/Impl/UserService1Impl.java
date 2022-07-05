package com.budai.annotation.autowire.service.Impl;

import com.budai.annotation.autowire.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Service() 没有指定名称时与实现类的类名同名
 * 如 class UserService1Impl implements UserService 则 bean 的名称为 userService
 */
@Service("userService1")
public class UserService1Impl implements UserService {

    /**
     * 消息打印
     */
    @Override
    public String print() {
        return "userService 1";
    }

}
