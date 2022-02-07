package cn.great.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.great.bean.User;

@Controller
public class UserController {

    @RequestMapping("/toRegister")
    public String toRegister( ) {
        return "register";
    }

    @RequestMapping("/registerUser")
    public String registerUsers(User user) {
        String name = user.getUsername();
        int pwd = user.getPassword();

        System.out.println(name);
        System.out.println(pwd);
        return "success";
    }
}
