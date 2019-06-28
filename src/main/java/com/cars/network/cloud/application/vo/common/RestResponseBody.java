package com.cars.network.cloud.application.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("响应结果")
public class RestResponseBody {

    @ApiModelProperty(value = "请求响应编码", position = 0)
    private Integer statusCode;

    @ApiModelProperty(value = "请求响应消息", position = 1)
    private String statusMessage;

    @ApiModelProperty(value = "请求响应数据", position = 2)
    private Object data;

    public RestResponseBody(Integer statusCode, String statusMessage, Object data) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
    }
}
