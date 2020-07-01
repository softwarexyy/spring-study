package com.yancy.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 使用注解实现AOP打印日志
 */
@Aspect // 标注切面
public class AnnotationAOPLog {

    @Before("execution(* com.yancy.service.UserServiceImpl.*(..))") // 标明 before和切入点位置
    public void printBefore() {
        System.out.println("==== 注解AOP打印：执行前 ====");
    }

    @After("execution(* com.yancy.service.UserServiceImpl.*(..))")
    public void printAfter() {
        System.out.println("==== 注解AOP打印：执行后 ====");
    }

    /**
     * 环绕通知
     * 注意点: 如果目标方法有int类型返回值，则环绕通知方法最好也有返回值，否则容易报错，
     * 或者将目标方法返回值改为包装类型
     * @param joinPoint 类似于切入点，只是能获取切入点目标方法的一些信息
     */
    @Around("execution(* com.yancy.service.UserServiceImpl.*(..))")
    public Object printAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("== 环绕前 ==");

        Object res = joinPoint.proceed();    // 标识方法执行、res是返回结果

        System.out.println("== 环绕后 ==");

        System.out.println(res);
        return res;
    }
}
