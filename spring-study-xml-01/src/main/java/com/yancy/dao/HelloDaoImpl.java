package com.yancy.dao;

/**
 * HelloDao的默认实现类
 */
public class HelloDaoImpl implements HelloDao {
    @Override
    public void printHello() {
        System.out.println("Hi!");
    }
}
