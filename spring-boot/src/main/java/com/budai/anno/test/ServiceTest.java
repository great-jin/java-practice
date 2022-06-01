package com.budai.anno.test;

import com.budai.anno.service.UserService;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
