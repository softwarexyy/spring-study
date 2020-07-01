package com.yancy.marriageDynamicAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MarraigeInvocationHandler implements InvocationHandler {

    // (1) 声明一个需要代理的接口
    private Marriage marriage;

    // (2) 设置代理接口的set方法
    public void setMarriage(Marriage marriage) {
        this.marriage = marriage;
    }

    // (3) 调用Proxy的静态方法生成代理类
    public Object getAgent() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), marriage.getClass().getInterfaces(), this);
    }

    // (4) 当handler调用实现的接口中的方法时（例如此处、调用Marriage接口中的getMarriage方法），会自动调用invoke方法来实现
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        signToAgent();
        getOneGirl();
        Object result = method.invoke(marriage, args);  // 调用实际的类的方法
        marriageSuccess();
        return result;
    }

    public void signToAgent() {
        System.out.println("去婚介所登记喜欢的姑娘类型");
    }

    public void getOneGirl() {
        System.out.println("找到一位姑娘");
    }

    public void marriageSuccess() {
        System.out.println("走入婚姻殿堂");
    }
}
