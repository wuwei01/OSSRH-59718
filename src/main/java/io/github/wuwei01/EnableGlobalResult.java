package io.github.wuwei01;

import io.github.wuwei01.config.GlobalAutoConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 注解启动全局结果入口
 * @Author wuwei
 * @Description //TODO
 * @Date 15:24 2020/8/14
 * @Param
 * @return
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(GlobalAutoConfig.class)
public @interface EnableGlobalResult {
}
