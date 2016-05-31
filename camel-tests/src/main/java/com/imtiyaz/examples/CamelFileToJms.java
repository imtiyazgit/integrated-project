package com.imtiyaz.examples;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class CamelFileToJms {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                //from("file:C:\\ALearning\\IntegratedProject\\camel-tests\\input?noop=true").bean(BeanLogger.class, "echo2").to("jms:incomingOrders");
                from("file:C:\\ALearning\\IntegratedProject\\camel-tests\\input?noop=true").bean(BeanLogger.class).to("jms:incomingOrders");
            }
        });
        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
