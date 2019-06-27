package com.pateo.qingcloud.app.utils;

import lombok.Data;

@Data
public class RestResponseBody {

    private Integer code;

    private String message;

    private Object data;

}
