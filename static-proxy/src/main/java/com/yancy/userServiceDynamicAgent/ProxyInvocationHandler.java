package com.yancy.userServiceDynamicAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理，掌握两个类：
 * 一是实现InvocationHandler接口的类，二是Proxy类。
 * 前者用来在主程序中、调用目的类的方法；
 * 后者是用newProxyInstance静态方法生成代理类。
 */
public class ProxyInvocationHandler implements InvocationHandler {

    /*被代理的接口 */
    private Object target;

    /*设置被代理的接口*/
    public void setTarget(Object target) {
        this.target = target;
    }

    /*生成代理类*/
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /*处理代理实例、返回结果 */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        return result;
    }

}
