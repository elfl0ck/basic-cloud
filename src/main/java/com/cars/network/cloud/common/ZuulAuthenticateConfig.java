package com.cars.network.cloud.common;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;


@Configuration
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "dev")
@Slf4j
public class ZuulAuthenticateConfig implements RequestInterceptor, CommandLineRunner {

    private static String HEADER_LABEL = "Authorization";

    @Autowired
    @Lazy
    private ZuulService loginService;

    private String token = "";

    // 获取登陆信息，
    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("feign发起调用请求，token是：{}", token);
        requestTemplate.header(HEADER_LABEL, token);
    }

    /**
     * 应用启动后执行的方法，CommandLineRunner
     * 应用启动执后，只会执行一次。
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("command line callback...");
        token = getToken();
        log.info("token is: {}", token);
    }

    /**
     * 模拟用户登录，获取token信息
     */
    private String getToken() throws Exception {
        String result = loginService.login("309810957@qq.com", "123456");
        if (result != null && !result.isEmpty()) {
            JSONObject json = new JSONObject(result);
            if (json.has("data")) {
                String tokenStr = json.getString("data");
                if (tokenStr != null && !tokenStr.isEmpty()) {
                    return tokenStr;
                }
            }
        }
        throw new Exception("获取token信息失败");
    }
}
