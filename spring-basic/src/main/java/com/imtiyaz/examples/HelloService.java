package com.imtiyaz.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloService {
    @Autowired
    private User user;

    public void sayHello() {
        System.out.println("Hello "+ user.getName() + " address is "+user.getAddress().getName());
    }
}
