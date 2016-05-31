package com.imtiyaz.examples;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by sg0222221 on 11/9/2015.
 */
public class ProcessorExample implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Processor called");
    }
}
