package com.imtiyaz.examples;

public class AnotherBean {
    public String sayHello() {
        System.out.println("Inside another bean--->");
        // This triggers default error handler in camel framework
         //throw new NullPointerException("NPE thrown from Another bean into camel platform...");
        return "BodyToLogAfterThisBeanComponentInRoute";
    }

    public void enrich() {
        System.out.println("Message enriched");
    }

    public void validate() {
        System.out.println("Method validated");
    }
}
