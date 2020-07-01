package com.yancy.printer;

import com.yancy.CommonInvocationHandler;
import org.junit.Test;

public class Main {
    /**
     * 通过通用的handler实现动态代理
     * @throws InterruptedException
     */
    @Test
    public void testByCommonHandler() throws InterruptedException {
        PrinterServiceImpl actualPrinter = new PrinterServiceImpl();    // 实际的打印机类

        // 定义handler、并设置需要代理的接口
        CommonInvocationHandler handler = new CommonInvocationHandler();
        handler.setTarget(actualPrinter);

        // 动态获取代理类
        PrinterService printerService = (PrinterService) handler.getAgent();

        printerService.print();
    }

    /**
     * 通过Printer专属的handler实现动态代理
     * @throws InterruptedException
     */
    @Test
    public void testByPrinterHandler() throws InterruptedException {
        PrinterServiceImpl printer = new PrinterServiceImpl();
        PrinterInvocationHandler handler = new PrinterInvocationHandler();
        handler.setPrinterService(printer);
        PrinterService service = (PrinterService) handler.getAgent();
        service.print();
    }
}
