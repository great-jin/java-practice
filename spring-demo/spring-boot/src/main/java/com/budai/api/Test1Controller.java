package com.budai.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 等价于 @Controller + @ResponseBody
 */
@RestController
@RequestMapping("/test1")
public class Test1Controller {

    @RequestMapping("/hello")
    public String TestAPI() {
        return "hello";
    }
}
