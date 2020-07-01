package com.yancy.userServiceDemo;

public class UserServiceAgentImpl implements IUserService {

    private UserServiceImpl userService;

    public UserServiceAgentImpl(){}

    public UserServiceAgentImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    // 新增功能
    public void printLog(String message) {
        System.out.println("[debug] 打印" + message + "日志");
    }

    @Override
    public void add() {
        setUserService(new UserServiceImpl());
        userService.add();
        printLog("add");
    }

    @Override
    public void query() {
        setUserService(new UserServiceImpl());
        userService.query();
        printLog("query");
    }
}
