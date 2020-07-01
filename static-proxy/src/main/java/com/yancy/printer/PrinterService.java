package com.yancy.printer;

/**
 * 打印机接口、提供打印方法
 */
public interface PrinterService {
    /**
     * 打印方法
     * @return true-打印成功； false-打印失败
     * @throws InterruptedException
     */
    Boolean print() throws InterruptedException;
}
