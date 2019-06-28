package com.cars.network.cloud.application.constant;

public enum RestResponseEnum {

    GLOBAL_EXCEPTION_STATUS(50000, "应用服务未主动捕获异常，全局异常拦截处理");

    private Integer statusCode;
    private String statusMessage;

    RestResponseEnum(Integer statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }
}
