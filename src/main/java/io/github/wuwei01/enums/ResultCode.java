package io.github.wuwei01.enums;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

/**
 * ClassName ResultCode
 * Description 常用定义错误Code
 * Author Wuwei
 * Date 2020/8/5 14:09
 * Version 1.0
 **/
@Getter
public enum ResultCode {

    /**
     * 1000 表示返回成功
     */
    SUCCESS(1000, "操作成功"),

    /**
     * 1001表示接口调用方异常提示
     */
    FAILED(1001, "响应失败"),

    /**
     * 1002表示接口参数校验异常提示
     */
    VALIDATE_FAILED(1002, "参数校验失败"),

    /**
     * 1003表示接口参数校验异常提示
     */
    VALIDATE_BODY_FAILED(1003, "参数体不能为空"),

    /**
     * 1004表示接口返回结果String类型异常提示
     */
    RESPONSE_ERROR(1004, "String返回错误"),

    /**
     * 1005表示文件为空
     */
    FILEERROR(1005, "文件为空"),

    /**
     * 1006表示用户不存在
     */
    USERERROR(1006, "用户不存在"),

    /**
     * 表示接口调用方异常提示
     */
    ACCESS_TOKEN_INVALID(1007,"access_token无效"),
    REFRESH_TOKEN_INVALID(1008,"refresh_token无效"),
    INSUFFICIENT_PERMISSIONS(1009,"该用户权限不足以访问该资源接口"),
    UNAUTHORIZED(1010,"访问此资源需要完全的身份验证"),
    NOT_ACCESS_TOKEN(4000,"请求头中缺少参数"),

    /**
     * 4004表示接口不存在
     */
    NOTFOUNDERROR(4004,"接口不存在"),

    /**
     * 5000表示接口调用未知错误
     */
    ERROR(5000,"未知错误");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
