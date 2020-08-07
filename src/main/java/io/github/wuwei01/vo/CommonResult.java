package io.github.wuwei01.vo;

import io.github.wuwei01.enums.ResultCode;
import lombok.Getter;


/**
 * @ClassName CommonResult
 * @Description 消息返回VO
 * @Author Wuwei
 * @Date 2020/8/5 14:13
 * @Version 1.0
 **/
@Getter
public class CommonResult<T> {
    /**
     * 状态码，1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String message;
    /**
     * 响应的具体数据
     */
    private T data;

    public CommonResult(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public CommonResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
}
