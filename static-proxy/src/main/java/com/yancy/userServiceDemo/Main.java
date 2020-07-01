package com.yancy.userServiceDemo;

import org.junit.Test;

public class Main {

    @Test
    public void serviceByImpl() {
        IUserService userService = new UserServiceImpl();
        userService.add();
        userService.query();
    }

    @Test
    public void serviceByAgent() {
        UserServiceAgentImpl userService = new UserServiceAgentImpl();
        userService.setUserService(new UserServiceImpl());

        userService.add();
        userService.query();
    }
}
