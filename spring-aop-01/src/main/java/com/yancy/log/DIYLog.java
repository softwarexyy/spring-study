package com.yancy.log;

public class DIYLog {

    public void diyBeforeLog(){
        System.out.println("自定义前置通知。");
    }

    public void diyAfterLog() {
        System.out.println("自定义后置通知。");
    }
}
