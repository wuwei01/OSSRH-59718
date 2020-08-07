package io.github.wuwei01.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.wuwei01.enums.ResultCode;
import io.github.wuwei01.exception.APIException;
import io.github.wuwei01.vo.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName ResponseControllerAdvice
 * @Description 统一封装Response
 * @Author Wuwei
 * @Date 2020/8/5 14:21
 * @Version 1.0
 **/
@RestControllerAdvice(basePackages = "${rep.repBasePackages}")
public class ResponseControllerAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class aClass) {
        // 如果接口返回的类型本身就是ResultVO那就没有必要进行额外的操作，返回false
        return !returnType.getParameterType().equals(CommonResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // String类型不能直接包装，所以要进行些特别的处理
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在CommonResult里后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(new CommonResult<>(data));
            } catch (JsonProcessingException e) {
                throw new APIException(ResultCode.RESPONSE_ERROR);
            }
        }
        // 将原本的数据包装在CommonResult里
        return new CommonResult<>(data);
    }
}
