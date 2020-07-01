package com.yancy.service;

import com.yancy.dao.HelloDao;

public class HelloServiceImpl implements HelloService {

    private HelloDao helloDao;

    public HelloDao getHelloDao() {
        return helloDao;
    }

    public void setHelloDao(HelloDao helloDao) {
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
