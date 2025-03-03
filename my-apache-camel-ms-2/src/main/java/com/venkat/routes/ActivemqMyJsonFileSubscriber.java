package com.venkat.routes;

import com.venkat.dto.CurrencyExchange;
import com.venkat.service.CurrencyExchangeProcessor;
import com.venkat.service.CurrencyExchangeTransformer;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ActivemqMyJsonFileSubscriber extends RouteBuilder {

    private final CurrencyExchangeProcessor currencyExchangeProcessor;
    private final CurrencyExchangeTransformer currencyExchangeTransformer;

    public ActivemqMyJsonFileSubscriber(CurrencyExchangeProcessor currencyExchangeProcessor, CurrencyExchangeTransformer currencyExchangeTransformer) {
        this.currencyExchangeProcessor = currencyExchangeProcessor;
        this.currencyExchangeTransformer = currencyExchangeTransformer;
    }

    @Override
    public void configure() throws Exception {
        from("activemq:my-json-queue")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .bean(currencyExchangeProcessor)
                .bean(currencyExchangeTransformer)
                .to("log:received-message-from-activemq");

    }
}
