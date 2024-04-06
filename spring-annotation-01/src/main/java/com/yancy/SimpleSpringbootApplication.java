package com.yancy;

import com.yancy.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;

@ComponentScan(value = "com.yancy")
public class SimpleSpringbootApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SimpleSpringbootApplication.class);
        IUserService userService = applicationContext.getBean("userServiceImpl", IUserService.class);
        String result = userService.getNameByCrdlsNo("18811363588");
        Logger logger = Logger.getLogger("YancyLogger");
        logger.info(result);
    }
}
