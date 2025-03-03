package com.venkat.routes;

import com.venkat.service.CurrencyExchangeProcessor;
import com.venkat.service.CurrencyExchangeTransformer;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActivemqMyCSVFileSubscriber extends RouteBuilder {

    private final CurrencyExchangeProcessor currencyExchangeProcessor;
    private final CurrencyExchangeTransformer currencyExchangeTransformer;

    public ActivemqMyCSVFileSubscriber(CurrencyExchangeProcessor currencyExchangeProcessor, CurrencyExchangeTransformer currencyExchangeTransformer) {
        this.currencyExchangeProcessor = currencyExchangeProcessor;
        this.currencyExchangeTransformer = currencyExchangeTransformer;
    }

    @Override
    public void configure() throws Exception {
        from("activemq:my-split-csv-queue")
                /*.unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .bean(currencyExchangeProcessor)
                .bean(currencyExchangeTransformer)*/
                .to("log:received-message-from-activemq");

    }
}
