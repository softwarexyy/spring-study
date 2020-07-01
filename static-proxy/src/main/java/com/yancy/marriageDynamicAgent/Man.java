package com.yancy.marriageDynamicAgent;

import com.yancy.CommonInvocationHandler;
import org.junit.Test;

/* 需要找姑娘结婚 */
public class Man {

    /**
     * 自己直接找姑娘结婚
     */
    @Test
    public void getWifeBySelf() {
        Woman woman1 = new Woman();
        woman1.getMarriage();
    }

    /**
     * 通过婚介所找姑娘结婚，静态代理
     */
    @Test
    public void getWifeByMarriageAgency(){
        MarriageAgency ma = new MarriageAgency();
        ma.getMarriage();
    }

    /**
     * 通过MarriageInvocationHandler动态代理
     */
    @Test
    public void getWifeDynamicAgent() {
        // 实际处理类
        Woman woman = new Woman();

        // 定义handler处理器
        MarraigeInvocationHandler handler = new MarraigeInvocationHandler();
        handler.setMarriage(woman); // 设置实际处理类

        Marriage marriage = (Marriage) handler.getAgent();      // 生成代理类

        marriage.getMarriage();
    }

    /**
     * 通过通用handler动态代理
     */
    @Test
    public void getWifeByCommonHandler() {
        Woman woman = new Woman();

        CommonInvocationHandler handler = new CommonInvocationHandler();
        handler.setTarget(woman);

        // 动态生成代理类，类型可用接口类型声明
        Marriage marriage = (Marriage) handler.getAgent();

        marriage.getMarriage();
    }
}
