package xyz.ibudai.service.Impl;

import xyz.ibudai.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 当存在多个实现类时必须指明名称
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
