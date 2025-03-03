package com.venkat.routes.one;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleLogProcessor {

   private Logger logger = LoggerFactory.getLogger(SimpleLogProcessor.class);

    public void process(String message) {
        logger.info("****SimpleLogProcessor ---- {}",message);
    }
}
