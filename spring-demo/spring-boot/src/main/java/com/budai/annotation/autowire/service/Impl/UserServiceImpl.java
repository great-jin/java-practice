package com.budai.annotation.autowire.service.Impl;

import com.budai.annotation.autowire.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 消息打印
     */
    @Override
    public String print() {
        return "userService";
    }

}
