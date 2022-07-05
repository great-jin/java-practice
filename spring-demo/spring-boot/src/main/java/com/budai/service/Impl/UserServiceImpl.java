package com.budai.service.Impl;

import com.budai.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Service() 没有指定名称时与实现类的类名同名
 * 如下则 bean 的名称为 userService
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 消息打印
     */
    @Override
    public String print() {
        return "userService";
    }

}
