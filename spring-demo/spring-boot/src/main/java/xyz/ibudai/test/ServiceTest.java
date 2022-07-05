package xyz.ibudai.test;

import xyz.ibudai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service")
public class ServiceTest {

    /**
     * 1. 非法，userService 多个继承类时需指定名称
     */
    /*@Autowired
    UserService userService;*/

    /**
     * 2. 合法，变量名与 @Service 中定义一致
     */
    @Autowired
    UserService userService1;

    /**
     * 3. 合法，@Qualifier 与 @Service 中定义一致
     */
    @Autowired
    @Qualifier(value = "userService1")
    UserService userService2;

    /**
     * 无法在 main() 与单元测试中调用 userService
     */
    @GetMapping("/print")
    public String TestAPI() {
        return userService1.print();
    }

}
