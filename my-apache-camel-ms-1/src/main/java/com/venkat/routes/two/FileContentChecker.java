package com.venkat.routes.two;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FileContentChecker {
    private Logger logger = LoggerFactory.getLogger(FileContentChecker.class);

    public boolean process(@Body String body, @Headers Map<String, String> headers, @ExchangeProperties Map<String, String> exchangeProperties) {
        logger.info("****FileContentChecker ---- body: {} \n headers: {} \n exchangeProperties: {} ",body, headers, exchangeProperties);
        return true;
    }
}
