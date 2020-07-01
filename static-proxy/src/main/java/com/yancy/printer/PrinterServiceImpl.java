package com.yancy.printer;

public class PrinterServiceImpl implements PrinterService {
    @Override
    public Boolean print() throws InterruptedException {
        System.out.println("打印机开始工作，打印中... ");
        Thread.sleep(1000);

        // 利用随机数模拟打印成功/失败场景
        int max = 100, min = 1;
        int random = (int) (Math.random() * 10);
        System.out.println(random);
        return random % 2 == 0;     // 如果是偶数则true 奇数false
    }


}
