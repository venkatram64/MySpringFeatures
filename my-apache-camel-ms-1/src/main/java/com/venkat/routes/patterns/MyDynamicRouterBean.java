package com.venkat.routes.patterns;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MyDynamicRouterBean {

    private final Logger logger = LoggerFactory.getLogger(MyDynamicRouterBean.class);

    int invocationCount;

    public String getNextEndpoint(@ExchangeProperties Map<String, String> properties,
                                  @Headers Map<String, String> headers, @Body String body) {
        logger.info("****MyDynamicRouterBean ---- properties: {} \n headers: {} \n body: {} ",properties, headers, body);
        invocationCount++;
        if(invocationCount % 3 == 0) return "direct:endpoint1";
        if(invocationCount % 3 == 1) return "direct:endpoint2";

        return null;
    }
}
