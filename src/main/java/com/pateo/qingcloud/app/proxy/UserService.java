package com.pateo.qingcloud.app.proxy;

import com.pateo.qingcloud.app.utils.RestResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.microservice.zuul}")
public interface UserService {

    @RequestMapping(value = "/system/user", method = RequestMethod.GET)
    RestResponseBody getUsers(@RequestParam(value = "pageNumber") Integer pageNumber,
                              @RequestParam(value = "pageSize") Integer pageSize);

}
