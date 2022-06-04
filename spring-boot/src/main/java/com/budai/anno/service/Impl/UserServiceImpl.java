package com.budai.anno.service.Impl;

import com.budai.anno.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void print() {
        System.out.println("Hello");
    }

}
