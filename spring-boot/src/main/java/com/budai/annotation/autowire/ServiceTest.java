package com.budai.annotation.autowire;

import com.budai.annotation.autowire.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTest {

    @Autowired
    UserService userService;

    /**
     * 无法在 main() 方法中调用 userService
     */
    @Test
    public void demo(){
        userService.print();
    }

}
