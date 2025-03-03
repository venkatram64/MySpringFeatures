package com.venkat.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:my-topic")
                .log("${body}")
                .to("log:received-message-from-kafka");
    }
}
