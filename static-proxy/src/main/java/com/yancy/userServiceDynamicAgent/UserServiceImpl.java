package com.yancy.userServiceDynamicAgent;

public class UserServiceImpl implements IUserService {
    @Override
    public void add() {
        System.out.println("add 添加用户");
    }

    @Override
    public void query() {
        System.out.println("query 查询用户");
    }
}
