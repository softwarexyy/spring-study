package com.yancy.service;

import com.yancy.dao.HelloDao;

public class HelloServiceImpl implements HelloService {

    private HelloDao helloDao;

    /**
     *  此处为重点: 利用set实现值的动态注入
     *  不需要在service的类中指定特定的dao层实现类，
     *  使用set方法、dao层接口代替具体的实现类，
     *  将控制权留给外部的调用者: 外部调用的时候，再传入dao层需要的实现类
     *  以上控制权留给外部调用者，即可理解为控制反转 Inverse Of Control (IOC)
     *
     * @param helloDao
     */
    public void setHelloDao(HelloDao helloDao){
        this.helloDao = helloDao;
    }

    /**
     * 实现业务层sayHello
     */
    @Override
    public void sayHello() {
        helloDao.printHello();
    }
}
