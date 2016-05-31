package com.imtiyaz.examples;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.Registry;
import org.apache.camel.spring.spi.ApplicationContextRegistry;

public class BeanLogger {
    public void echo(String msg, CamelContext context, Registry registry) {
        System.out.println("Payload="+msg +"\n"+
                            "CamelContext="+context +"\n"+
                            "Registry="+registry);


    }

   /* public void echo2(String msg, CamelContext context) {
        System.out.println("Payload="+msg +"\n"+
                "CamelContext"+context);
    }*/

    /**@Handler
    public void echo(String msg) {
        System.out.println("Echo");
    }
    **/
}
