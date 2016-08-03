package com.juicelabs.camel.helloworld;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Recv {

    public static void main(String args[]) throws Exception {

        CamelContext context = new DefaultCamelContext();
        //context.
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("rabbitmq://localhost:5672/test1").to("stream:out");
            }
        });
        context.start();
    }
}
