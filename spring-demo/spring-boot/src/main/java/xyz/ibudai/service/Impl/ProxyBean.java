package xyz.ibudai.service.Impl;

import xyz.ibudai.interceptor.Interceptor;
import xyz.ibudai.model.Invocation;
import xyz.ibudai.service.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {

    private Object target = null;

    private Interceptor interceptor = null;

    public static Object getProxyBean(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        // 保存被代理对象
        proxyBean.target = target;
        // 保存拦截器
        proxyBean.interceptor = interceptor;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (java.lang.reflect.InvocationHandler) proxyBean);
    }

    /**
     * 处理代理对象方法逻辑
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(target, method, args);
        Object retObj = null;
        try {
            if (this.interceptor.before()) {
                retObj = this.interceptor.around((org.aopalliance.intercept.Invocation) invocation);
            } else {
                retObj = method.invoke(target, args);
            }
        } catch (Exception ex) {
            exceptionFlag = true;
        }
        this.interceptor.after();
        if (exceptionFlag) {
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }

}
