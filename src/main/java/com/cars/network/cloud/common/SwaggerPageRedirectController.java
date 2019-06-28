package com.cars.network.cloud.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class SwaggerPageRedirectController {

    @RequestMapping(value = "/swagger", method = RequestMethod.GET)
    public String redirect(){
        return "redirect:/swagger-ui.html";
    }
}
