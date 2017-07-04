package com.imtiyaz.examples;

/**
 * Created by SG0222221 on 11/13/2015.
 */
public class Hello  {
    private String message = null;

    public Hello() {
        message = "Hello, world";
    }

    public Hello(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void sayHello() {
        System.out.println(message);
    }
}