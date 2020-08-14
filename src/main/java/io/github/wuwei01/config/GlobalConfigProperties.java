package io.github.wuwei01.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName 核心配置
 * @Description TODO
 * @Author Wuwei
 * @Date 2020/8/14 15:19
 * @Version 1.0
 **/

@Data
@ConfigurationProperties(prefix = "global.result.handler")
public class GlobalConfigProperties {

    private boolean enableSwagger = true;
}
