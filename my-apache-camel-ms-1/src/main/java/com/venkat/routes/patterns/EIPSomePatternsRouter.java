package com.venkat.routes.patterns;

import com.venkat.dto.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class EIPSomePatternsRouter extends RouteBuilder {

    private final CsvSplitter csvSplitter;
    private final MyDynamicRouterBean myDynamicRouterBean;

    public EIPSomePatternsRouter(CsvSplitter csvSplitter, MyDynamicRouterBean myDynamicRouterBean) {
        this.csvSplitter = csvSplitter;
        this.myDynamicRouterBean = myDynamicRouterBean;
    }

    @Override
    public void configure() throws Exception {

        //enable tracing
        //getContext().setTracing(true);
        //configuring dead letter channel
        //errorHandler(deadLetterChannel("activemq:dead-letter-queue"));

        //Pipeline
        //Content Based Routing Pattern
        //Multicast Pattern

        /*from("timer:multicast?period=10000")
                .multicast()
                .to("log:something1", "log:something2","log:something3");*/

        //Split
        /*from("file:my-apache-camel-ms-1/data/input/csv")
                .unmarshal().csv()
                .split(body())
                .to("log:split-files");*/

        /*from("file:my-apache-camel-ms-1/data/input/csv")
                .unmarshal().csv()
                .split(body())
                .to("activemq:my-split-csv-queue");*/
        //split
        /*from("file:my-apache-camel-ms-1/data/input/csv")
                .convertBodyTo(String.class)
                //.split(body(), ",")
                .split(method(csvSplitter))
                .to("activemq:my-split-csv-queue");*/

        //aggregate

        from("file:my-apache-camel-ms-1/data/input/aggregate")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .aggregate(simple("${body.to}"), new MyAggregationStrategy())
                .completionSize(3)
                .to("log:aggregate-json");

        //routing slip
        String routingSlip = "direct:endpoint1,direct:endpoint2";

        /*from("timer:routingSlip?period=10000")
                .transform().constant("My Message is Hardcoded")
                .routingSlip(simple(routingSlip));

        from("direct:endpoint1")
                .to("log:directendpoint1");

        from("direct:endpoint2")
                .to("log:directendpoint2");

        from("direct:endpoint3")
                .to("log:directendpoint3");*/

        //dynamic routing pattern

        from("timer:dynamicRoutingSlip?period={{timePeriod}}")
                .transform().constant("My Message is Hardcoded")
                .dynamicRouter(method(myDynamicRouterBean));

        from("direct:endpoint1")
                .wireTap("log:wire-tap") //additional end point
                .to("{{endpoint-for-logging}}");

        from("direct:endpoint2")
                .to("log:directendpoint2");

        from("direct:endpoint3")
                .to("log:directendpoint3");



    }
}
