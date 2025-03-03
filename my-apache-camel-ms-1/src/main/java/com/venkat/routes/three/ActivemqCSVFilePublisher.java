package com.venkat.routes.three;

import org.apache.camel.builder.RouteBuilder;

//@Component
public class ActivemqCSVFilePublisher extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        //CSV
        //CurrencyExchange
        //Exchange[ExchangePattern: InOnly, BodyType: java.util.ArrayList, Body: 1001,USD,INR,70]
        from("file:my-apache-camel-ms-1/data/input/csv/mq")
                .log("${body}")
                .to("activemq:my-split-csv-queue");
    }
}
