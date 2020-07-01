package com.yancy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring配置类，其中可用注解bean配置一些SpringBean，
 * 也可以空值此类，在需要注册为bean的具体的类上加注解
 * 注解 Component/Service/Repository/Controller等
 *
 * 在Springboot中，主启动类包含了Configuration注解，
 * 默认了包扫描路径，因此可实现SpringBean的自动声明
 */
@Configuration
@ComponentScan(basePackages = {"com.yancy"})    // 设定扫描路径
    public class Config {
}
