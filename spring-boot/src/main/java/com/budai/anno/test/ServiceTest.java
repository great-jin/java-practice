package com.budai.anno.test;

import org.junit.Test;

import com.budai.anno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void demo(){
        userService.print();
    }

    public static void main(String[] args) {
//        userService.print();
    }
}
