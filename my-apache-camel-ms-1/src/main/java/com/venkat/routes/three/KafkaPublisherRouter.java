package com.venkat.routes.three;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisherRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:my-apache-camel-ms-1/data/input/kafka")
                .log("${body}")
                .to("kafka:my-topic");
    }
}
