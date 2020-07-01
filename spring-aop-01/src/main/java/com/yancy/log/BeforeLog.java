package com.yancy.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置通知方法
 */
public class BeforeLog implements MethodBeforeAdvice {

    /**
     * 这里需要理解一下参数，
     * 例如希望在A类的B方法调用前，自动调用一系列程序C，
     * 那么对应的参数就如下：
     * @param method  B方法
     * @param objects B方法的参数
     * @param o      A类对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("---- 调用方法信息: ----");
        System.out.println("类:" + o.getClass().getName());
        System.out.println("方法：" + method.getName());
        System.out.println("参数列表长度: " + objects.length);
        for (Object arg: objects) {
            System.out.println("参数：" + arg);
        }
        System.out.println("---- 打印信息完成。 ----");
    }
}
