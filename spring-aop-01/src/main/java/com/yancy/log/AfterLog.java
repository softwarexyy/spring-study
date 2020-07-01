package com.yancy.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置通知方法
 */
public class AfterLog implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        if (returnValue == null) {
            System.out.println("方法执行完毕");
        } else {
            System.out.println("方法执行完毕，返回值： " + returnValue);
        }
    }
}
