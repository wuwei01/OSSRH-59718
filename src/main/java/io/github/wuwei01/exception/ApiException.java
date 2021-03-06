package io.github.wuwei01.exception;

import io.github.wuwei01.enums.ResultCode;
import lombok.Getter;


/**
 * ClassName APIException
 * Description TODO
 * @Author Wuwei
 * Date 2020/8/5 14:16
 * Version 1.0
 **/
@Getter
public class ApiException extends RuntimeException{
    private int code;
    private String message;

    public ApiException(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public ApiException(int code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }
}
