package com.yancy.userServiceDynamicAgent;

import org.junit.Test;

public class Main {

    @Test
    public void serviceByImpl() {
        IUserService userService = new UserServiceImpl();
        userService.add();
        userService.query();
    }

    @Test
    public void serviceByAgent() {

        /**
         * 三个步骤：
         * （1）定义真实角色；
         * （2）定义一个实现了 InvocationHandler接口的类对象;
         * （3）给 handler 设置需要调用的接口；
         * （4）动态获取代理类。
         */
        UserServiceImpl userServiceImpl = new UserServiceImpl();    // 定义真实角色

        ProxyInvocationHandler handler = new ProxyInvocationHandler();  // 定义一个实现InvocationHandler接口的对象
        handler.setTarget(userServiceImpl);    // 在handler中设置 需要调用的接口对象

        IUserService userServiceByProxy = (IUserService) handler.getProxy();  // 动态获取代理类

        userServiceByProxy.add();
        userServiceByProxy.query();
    }

}
