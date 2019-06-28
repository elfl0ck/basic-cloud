package com.cars.network.cloud.common;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "${feign.microservice.zuul}")
public interface ZuulService {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    String login(@RequestParam(value = "username") String username,
                 @RequestParam(value = "password") String password);

}
