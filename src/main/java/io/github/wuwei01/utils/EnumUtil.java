package io.github.wuwei01.utils;

import org.springframework.util.StringUtils;

/**
 * @ClassName: EnumUtil
 * @Description: 枚举工具类，根据枚举key获取value
 * @Author: wuwei
 * @Date: 2021年5月13日10:01:42
 * @Version: 1.0
 */
public class EnumUtil {
    public static <T extends EnumImpl> String getCodeDesc(Class<T> clazz, String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (T _enum : clazz.getEnumConstants()) {
            if (_enum.getCode().trim().equalsIgnoreCase(code)) {
                return _enum.getDesc();
            }
        }
        return null;
    }
}
