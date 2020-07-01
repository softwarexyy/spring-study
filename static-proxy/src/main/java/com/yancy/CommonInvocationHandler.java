package com.yancy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通用的动态代理Handler类
 */
public class CommonInvocationHandler implements InvocationHandler {
    private Object target; // 需要代理的接口

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getAgent() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        if (result != null) {
            PrintLog(target.getClass().getName(), method.getName(), (Boolean) result);
        } else {
            PrintLog(target.getClass().getName(), method.getName(), true);
        }
        return result;
    }

    // 打印日志
    public void PrintLog(String className, String methodName, Boolean success) {
        System.out.println("调用类 " + className + " 的 " + methodName + " 方法 " + (success ? "完成" : "失败"));
    }
}
