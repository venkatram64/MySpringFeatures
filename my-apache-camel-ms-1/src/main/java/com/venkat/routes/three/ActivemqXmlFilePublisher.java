package com.venkat.routes.three;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActivemqXmlFilePublisher extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        //JSON
        //CurrencyExchange
        //{  "id": 1000,  "from": "USD",  "to": "INR",  "conversionMultiple": 70}
        from("file:my-apache-camel-ms-1/data/input/xml")
                .log("${body}")
                .to("activemq:my-xml-queue");
    }
}
