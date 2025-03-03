package com.venkat.routes;

import com.venkat.dto.CurrencyExchange;
import com.venkat.service.CurrencyExchangeProcessor;
import com.venkat.service.CurrencyExchangeTransformer;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActivemqMyXmlFileSubscriber extends RouteBuilder {

    private final CurrencyExchangeProcessor currencyExchangeProcessor;
    private final CurrencyExchangeTransformer currencyExchangeTransformer;

    public ActivemqMyXmlFileSubscriber(CurrencyExchangeProcessor currencyExchangeProcessor, CurrencyExchangeTransformer currencyExchangeTransformer) {
        this.currencyExchangeProcessor = currencyExchangeProcessor;
        this.currencyExchangeTransformer = currencyExchangeTransformer;
    }

    @Override
    public void configure() throws Exception {

        from("activemq:my-xml-queue")
                .unmarshal()
                .jacksonXml(CurrencyExchange.class)
                //.log("${body}")
                .to("log:received-message-from-activemq:my-xml-queue");

    }
}
