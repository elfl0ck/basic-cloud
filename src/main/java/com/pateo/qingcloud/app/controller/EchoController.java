package com.pateo.qingcloud.app.controller;

import com.pateo.qingcloud.app.proxy.TsfService;
import com.pateo.qingcloud.app.proxy.UserService;
import com.pateo.qingcloud.app.utils.RestResponseBody;
import com.pateo.qingcloud.config.ProviderNameConfig;
import feign.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.tsf.core.util.TsfSpringContextAware;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@Slf4j
@Api(value = "示例")
public  class EchoController {
    private static final Logger LOG = LoggerFactory.getLogger(EchoController.class);

    @Autowired
    private ProviderNameConfig providerNameConfig;

    @Autowired
    private UserService userService;

    @Autowired
    private TsfService tsfService;


    @RequestMapping(value = "/echo/{param}", method = RequestMethod.GET)
    @ApiOperation(value = "echo服务", notes = "echo服务")
    public String echo(@PathVariable String param) {
        LOG.info("provider-demo -- request param: [" + param + "]");
        String result = "request param: " + param + ", response from " + providerNameConfig.getName();
        LOG.info("provider-demo -- provider config name: [" + providerNameConfig.getName() + ']');
        LOG.info("provider-demo -- response info: [" + result + "]");
        System.out.println(userService.getUsers(1, 10));
        return result;
    }

    @RequestMapping(value = "/config/{path}/value", method = RequestMethod.GET)
    public String config(@PathVariable String path) {
        return TsfSpringContextAware.getProperties(path);
    }

    @RequestMapping(value = "/download/excel", method = RequestMethod.GET)
    public RestResponseBody download(HttpServletResponse response) throws IOException {
        RestResponseBody result = new RestResponseBody();
        Response resp = tsfService.download();
        if (resp == null || resp.status() != 200) {
            log.info("feign调用远程API失败");
            result.setCode(resp.status());
            result.setMessage(resp.body().toString());
            result.setData(resp.headers());
            return result;
        }
        response.setHeader("Content-Disposition", "attachment; filename=1557906371705.xls");
        response.setHeader("Content-Type", "application/msexcel");
        InputStream inputStream = resp.body().asInputStream();
        IOUtils.copy(inputStream, response.getOutputStream());
        return null;
    }
}