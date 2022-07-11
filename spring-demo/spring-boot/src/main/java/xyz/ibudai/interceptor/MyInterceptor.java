package xyz.ibudai.interceptor;

import org.aopalliance.intercept.Invocation;

public class MyInterceptor implements Interceptor {

    /**
     * 事前方法
     */
    @Override
    public boolean before() {
        System.out.println("before ......");
        return true;
    }

    /**
     * 事后方法
     */
    @Override
    public void after() {
        System.out.println("after ......");
    }

    /**
     * 取代原有事件方法
     *
     * @param invocation
     */
    @Override
    public Object around(Invocation invocation) throws Throwable {
        System.out.println("around before . . . . . ");
        Object obj = invocation.proceed();
        System.out.println("around before . . . . . ");
        return obj;
    }

    /**
     * 是否使用around 方法取代原有方法
     */
    @Override
    public boolean useAround() {
        return true;
    }

    /**
     * 是否返回方法，事件没有发生异常执行
     */
    @Override
    public void afterReturning() {
        System.out.println("after Returning . . . . . ");
    }

    /**
     * 事后异常方法， 当事件发生异常后执行
     */
    @Override
    public void afterThrowing() {
        System.out.println("after Throwing . . . . . ");
    }
}
