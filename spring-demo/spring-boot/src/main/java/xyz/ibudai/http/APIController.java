package xyz.ibudai.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 等价于 @Controller + @ResponseBody
 */
@RestController
@RequestMapping("test1")
public class APIController {

    @GetMapping("/1")
    public String TestAPI() {
        return "API say hello ";
    }

    @RequestMapping(path = "/2", method = RequestMethod.GET)
    public String Test1API() {
        return "API 1 say hello ";
    }
}