package xyz.ibudai.service;

import java.lang.reflect.Method;

public interface InvocationHandler {

    /**
     * 处理代理对象方法逻辑
     */
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
