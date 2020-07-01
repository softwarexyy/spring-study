package com.yancy.service;

public class UserServiceImpl implements UserService {
    @Override
    public int add(String arg1, String arg2) {
        System.out.println("==== [RUN] 增加用户 ====");
        return 10;   // 随便写的返回值
    }

    @Override
    public void delete() {
        System.out.println("==== [RUN] 删除用户 ====");
    }

    @Override
    public void update() {
        System.out.println("==== [RUN] 更新用户 ====");
    }

    @Override
    public void query() {
        System.out.println("==== [RUN] 查询用户 ====");
    }
}