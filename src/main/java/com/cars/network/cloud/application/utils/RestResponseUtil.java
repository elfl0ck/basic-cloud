package com.cars.network.cloud.application.utils;

import com.cars.network.cloud.application.constant.RestResponseEnum;
import com.cars.network.cloud.application.vo.common.RestResponseBody;

public class RestResponseUtil {

    public static final RestResponseBody success() {
        return new RestResponseBody(0, "OK", "success");
    }

    public static final RestResponseBody success(String statusMessage, Object data) {
        return new RestResponseBody(0, statusMessage, data);
    }

    public static final RestResponseBody error(RestResponseEnum status, Object data) {
        return new RestResponseBody(status.getStatusCode(), status.getStatusMessage(), data);
    }

    public static final RestResponseBody fatal() {
        return new RestResponseBody(500, "Fatal", "fatal");
    }


}
