package com.venkat.routes.two;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFileRouter extends RouteBuilder {

    private final FileContentChecker fileContentChecker;

    public MyFileRouter(FileContentChecker fileContentChecker) {
        this.fileContentChecker = fileContentChecker;
    }

    @Override
    public void configure() throws Exception {

        //Pipeline pattern, this is the default pattern

        from("file:my-apache-camel-ms-1/data/input/file?noop=true")
                //.pipeline()
                .routeId("my-file-router")
                .transform().body(String.class)
                .choice()//content based routing pattern
                    .when(simple("${file:ext} ends with 'xml'"))
                        .log("XML FILE")
                    //.when(simple("${body} contains 'USD'"))
                    .when(method(fileContentChecker))
                        .log("Not an XML but contains USD")
                    .otherwise()
                        .log("Not an XML FILE")
                .end()
                //.log("${body}")
                //.to("direct://log-file-values")//using below endpoint as route
                .to("file:my-apache-camel-ms-1/data/output");

            //other way to log information, defining a route
            //Pipeline pattern
            from("direct:log-file-values")
                    .log("${messageHistory} ${headers.CamelFileAbsolute} ${headers.CamelFileLastModified}")
                    .log("${file:name} ${file:name.ext} ${file:name.noext} ${file:onlyname}")
                    .log("${file:parent} ${file:path} ${file:absolute}")
                    .log("${routeId} ${camelId} ${body}");
    }
}
