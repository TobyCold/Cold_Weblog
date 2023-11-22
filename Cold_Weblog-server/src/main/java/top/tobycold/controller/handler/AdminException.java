package top.tobycold.controller.handler;

import cn.hutool.core.exceptions.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.tobycold.dao.Response;

@RestControllerAdvice
@Slf4j
public class AdminException {
    /**
     * 异常处理器
     */
    @ExceptionHandler(NullPointerException.class)
    public Response JwtException(NullPointerException e) {
        return Response.error("异常");
    }
    @ExceptionHandler(ValidateException.class)
    public Response JwtException(ValidateException e) {
        return Response.error("验证失败");
    }
}
