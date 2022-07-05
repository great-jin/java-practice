package com.budai.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test2")
public class ValueTest {

    @Value("${myKey.info}")
    private String info;

//    @Value("#{User.name}")
    private String message;

    @GetMapping("info")
    public String getInfo() {
        return info;
    }

    @GetMapping("message")
    public String getMessage() {
        return message;
    }
}
