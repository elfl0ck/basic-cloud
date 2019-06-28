package com.cars.network.cloud.common;

import com.cars.network.cloud.application.constant.RestResponseEnum;
import com.cars.network.cloud.application.utils.RestResponseUtil;
import com.cars.network.cloud.application.vo.common.RestResponseBody;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public RestResponseBody filterAllException(Exception e) {
        e.printStackTrace();
        return RestResponseUtil.error(RestResponseEnum.GLOBAL_EXCEPTION_STATUS, e.getMessage());
    }

}
