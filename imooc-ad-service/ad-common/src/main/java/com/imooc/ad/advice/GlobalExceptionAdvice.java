package com.imooc.ad.advice;

import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> adExceptionHandler(HttpServletRequest request, AdException e) {
        CommonResponse<String> response = new CommonResponse<String>(-1, "business error");
        response.setData(e.getMessage());
        return response;
    }
}
