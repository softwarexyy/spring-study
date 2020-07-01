package com.yancy.pojo;

public class Hello {
    private String message;

    public Hello() {
        System.out.println("调用Hello默认构造方法。");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "message='" + message + '\'' +
                '}';
    }
}
