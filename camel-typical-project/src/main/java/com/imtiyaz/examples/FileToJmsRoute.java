package com.imtiyaz.examples;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class FileToJmsRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // Lets make this in spring so that all routes can see this. Even if it is here, all routes can see that.
        // but more logical to be in spring xml
      /*  errorHandler(defaultErrorHandler()
        .maximumRedeliveries(2)
        .redeliveryDelay(1000)
        .retryAttemptedLogLevel(LoggingLevel.WARN));

        onException(OrderFailedException.class).maximumRedeliveries(5);*/

        from("file:src/data?noop=true").
                process(new ProcessorExample()).
                bean(BeanLogger.class). // This is a bean from package scan
                beanRef("anotherBean", "sayHello"). // This is a spring bean from xml
                log("Received body before sending to queue {body}").
                to("seda:queue.inbox");

        // You can configure error handler at route level as well
        from("seda:queue.inbox").errorHandler(deadLetterChannel("log:DLC")
                        .maximumRedeliveries(5)
                        .retryAttemptedLogLevel(LoggingLevel.INFO).redeliveryDelay(250).backOffMultiplier(2))
                .beanRef("anotherBean", "enrich")
                .beanRef("anotherBean", "validate")
                .to("jms:incomingOrders");



    }
}
