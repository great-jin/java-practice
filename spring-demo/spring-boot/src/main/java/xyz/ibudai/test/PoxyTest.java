package xyz.ibudai.test;

import xyz.ibudai.interceptor.MyInterceptor;
import xyz.ibudai.service.Impl.ProxyBean;
import xyz.ibudai.service.HelloService;
import xyz.ibudai.service.Impl.HelloServiceImpl;

public class PoxyTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("budai");
        proxy.sayHello(null);
    }
}
