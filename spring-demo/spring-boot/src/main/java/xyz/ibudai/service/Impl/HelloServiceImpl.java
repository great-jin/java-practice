package xyz.ibudai.service.Impl;

import xyz.ibudai.service.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello" + name);
    }

}
