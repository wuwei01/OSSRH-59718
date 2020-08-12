package io.github.wuwei01.exception;

import io.github.wuwei01.enums.ResultCode;
import io.github.wuwei01.vo.CommonResult;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName NotFoundException
 * Description TODO
 * Author Wuwei
 * Date 2020/8/12 14:17
 * Version 1.0
 **/

@Controller
public class NotFoundException implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping(value = {"/error"})
    @ResponseBody
    public CommonResult error(HttpServletRequest request, HttpServletResponse response) {
        //定义为正常返回
        response.setStatus(HttpStatus.OK.value());
        return new CommonResult(ResultCode.NOT_FOUND_ERROR,null);
    }
}
