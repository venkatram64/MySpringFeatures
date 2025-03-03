package com.venkat.routes.one;


import org.apache.camel.builder.RouteBuilder;

//@Component
public class MyFirstTimerRouter extends RouteBuilder {

    private final CurrentTimerBean currentTimerBean;
    private final SimpleLogProcessor simpleLogProcessor;

    public MyFirstTimerRouter(CurrentTimerBean currentTimerBean, SimpleLogProcessor simpleLogProcessor) {
        this.currentTimerBean = currentTimerBean;
        this.simpleLogProcessor = simpleLogProcessor;
    }

    @Override
    public void configure() throws Exception {
        //queue --> timer
        //transformation
        //database -->log
        //Exchange[ExchangePattern: InOnly, BodyType: null, Body: [Body is null]]
        from("timer:first-timer") //null
                .log("${body}")
                .transform().constant("My Constant Message")
                .log("${body}")
                //.transform().constant("Time now is " + LocalDateTime.now())
                //.bean("currentTimerBean")
                //processing
                //transformation
                .bean(currentTimerBean, "getCurrentTime")
                .log("${body}")
                .bean(simpleLogProcessor)
                .log("${body}")
                .process(new MyProcessor())
                .to("log:first-timer");
    }
}
