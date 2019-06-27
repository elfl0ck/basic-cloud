package com.pateo.qingcloud.app.proxy;

import com.pateo.qingcloud.app.utils.RestResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "${feign.microservice.zuul}")
public interface ZuulService {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    RestResponseBody login(@RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password);

}
