package com.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

public class User {
    // 使用Autowired自动装配
    @Autowired
    private ChnlStat chnlStat;

    // 无法检测出使用哪个bean自动装配时，则使用Qualifier指定bean的名称
    @Autowired
    @Qualifier("customer2")
    private Customer customer;

    @Override
    public String toString() {
        return "User{" +
                "chnlStat=" + chnlStat +
                ", customer=" + customer +
                '}';
    }
}
