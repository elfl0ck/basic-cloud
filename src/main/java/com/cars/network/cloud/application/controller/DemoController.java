package com.cars.network.cloud.application.controller;

import com.cars.network.cloud.application.utils.RestResponseUtil;
import com.cars.network.cloud.application.vo.common.RestResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @RequestMapping(value = "/demoo")
    public RestResponseBody demo(@RequestParam(value = "pageSize") Integer pageSize,
                                 @RequestParam(value = "pageNumber") Integer pageNumber) {
        if (pageNumber != null && pageSize != null) {
            return RestResponseUtil.success("demo", pageNumber + "," + pageSize);
        }
        return RestResponseUtil.success();
    }

}
