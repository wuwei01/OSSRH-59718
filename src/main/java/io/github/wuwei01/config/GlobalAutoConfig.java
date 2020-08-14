package io.github.wuwei01.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName 全局自动配置
 * @Description TODO
 * @Author Wuwei
 * @Date 2020/8/14 15:16
 * @Version 1.0
 **/

@Configuration
@EnableConfigurationProperties(GlobalConfigProperties.class)
@ComponentScan(basePackages = {"io.github.wuwei01.advice"})
public class GlobalAutoConfig {

}
