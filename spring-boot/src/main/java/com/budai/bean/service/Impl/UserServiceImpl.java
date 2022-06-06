package com.budai.bean.service.Impl;

import com.budai.bean.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void print() {
        System.out.println("Hello");
    }

}
