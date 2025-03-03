package com.venkat.routes.three;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CurrencyExchangeConsumerRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().host("localhost").port(8082);
        from("timer:rest-api-consumer?period=10000")
                .setHeader("from", () -> "USD")
                .setHeader("to", () -> "INR")
                .log("${body}")
                .to("rest:get:/currency-exchange/from/{from}/to/{to}")
                .log("${body}");
    }
}
