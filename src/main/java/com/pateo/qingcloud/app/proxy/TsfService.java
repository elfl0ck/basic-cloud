package com.pateo.qingcloud.app.proxy;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "vehicle", url = "http://10.6.224.177:32262")
public interface TsfService {

    @RequestMapping(value = "/tsp-portal/basic/dealerManage/dealerExcel", method = RequestMethod.GET)
    Response download();
}
