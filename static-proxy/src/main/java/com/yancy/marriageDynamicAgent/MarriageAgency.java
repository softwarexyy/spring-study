package com.yancy.marriageDynamicAgent;

import java.util.logging.Logger;

public class MarriageAgency implements Marriage {

    Logger logger = Logger.getLogger("MarriageAgentLogger");

    private Woman woman;

    public MarriageAgency() {
        this.woman = new Woman();
    }

    public MarriageAgency(Woman woman) {
        this.woman = woman;
    }

    /*
    获取姑娘
     */
    private Woman getWoman() {
        Woman woman = new Woman();
        return woman;
    }

    /**
     * 通过代理调用结婚方法，可增加许多额外步骤，保证目的对象功能独立
     */
    @Override
    public void getMarriage() {
        sign();
        searchWoman();
        woman.getMarriage();        // 代理类内部、其实是调用了目的类对象
        fee();
    }

    public void sign() {
        logger.info("在婚介所登记，登记喜欢的女生类型");
    }

    public void searchWoman() {
        logger.info("婚介所寻找姑娘");
    }

    public void fee(){
        logger.info("婚介所收钱");
    }
}
