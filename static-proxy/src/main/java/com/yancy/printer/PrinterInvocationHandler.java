package com.yancy.printer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PrinterInvocationHandler implements InvocationHandler {

    // 声明需要调用方法的所属接口
    private PrinterService printerService;

    public void setPrinterService(PrinterService printerService) {
        this.printerService = printerService;
    }

    // 获取代理类
    public Object getAgent() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), printerService.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(printerService, args);
        return result;
    }
}
