package com.budai.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String TestAPI() {
        return "hello";
    }

}