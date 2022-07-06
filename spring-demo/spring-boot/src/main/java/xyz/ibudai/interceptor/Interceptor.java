package xyz.ibudai.interceptor;

import org.aopalliance.intercept.Invocation;

public interface Interceptor {

    /**
     * 事前方法
     */
    boolean before();

    /**
     * 事后方法
     */
    void after();

    /**
     * 取代原有事件方法
     */
    Object around(Invocation invocation) throws Throwable;

    /**
     * 是否使用around 方法取代原有方法
     */
    boolean useAround();

    /**
     * 是否返回方法，事件没有发生异常执行
     */
    void afterReturning();

    /**
     * 事后异常方法， 当事件发生异常后执行
     */
    void afterThrowing();

}
