package com.yancy.marriageAgentDemo;

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
     * 通过婚介所找姑娘结婚
     */
    @Test
    public void getWifeByMarriageAgency(){
        MarriageAgency ma = new MarriageAgency();
        ma.getMarriage();
    }
}
