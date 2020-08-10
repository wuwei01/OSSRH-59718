package io.github.wuwei01.config;


import io.github.wuwei01.enums.ResultCode;
import io.github.wuwei01.exception.ApiException;
import io.github.wuwei01.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * ClassName GloablExceptionAdvice
 * Description 全局异常处理
 * Author Wuwei
 * Date 2020/8/5 15:07
 * Version 1.0
 **/
@Slf4j
@RestControllerAdvice
public class GloablExceptionAdvice {
    /**
     * 参数校验失败处理器
     * @param e 参数校验异常
     * @return CommonResult
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new CommonResult<>(ResultCode.VALIDATE_FAILED,objectError.getDefaultMessage());
    }
    /**
     * 接口响应失败处理器
     * @param e 接口响应异常
     * @return CommonResult
     */
    @ExceptionHandler(ApiException.class)
    public CommonResult<String> apiExceptionHandler(ApiException e) {
        // 注意哦，这里返回类型是自定义响应体
        return new CommonResult<>(ResultCode.FAILED,e.getMessage());
    }

    /**
     * 缺少请求体异常处理器
     *
     * @param e 缺少请求体异常
     * @return CommonResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public CommonResult<String> parameterBodyMissingExceptionHandler(HttpMessageNotReadableException e) {
        return new CommonResult<>(ResultCode.VALIDATE_BODY_FAILED,e.getMessage());
    }

    /**
     * 忽略参数异常处理器
     *
     * @param e 忽略参数异常
     * @return CommonResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public CommonResult<String> parameterMissingExceptionHandler(MissingServletRequestParameterException e) {
        return new CommonResult<>(ResultCode.VALIDATE_FAILED, "请求参数 " + e.getParameterName() + " 不能为空");
    }

    /**
     * 方法错误异常处理器
     *
     * @param e 忽略参数异常
     * @return CommonResult
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult<String> notSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        return new CommonResult<>(ResultCode.ERROR, e.getMessage());
    }


    /**
     * 404异常处理器
     *
     * @param e 忽略参数异常
     * @return CommonResult
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonResult<String> notHandlerFoundExceptionHandler(NoHandlerFoundException e) {
        return new CommonResult<>(ResultCode.NOTFOUNDERROR,"没有找到");
    }

}
