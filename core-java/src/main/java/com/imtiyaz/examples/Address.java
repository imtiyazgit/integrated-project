package com.imtiyaz.examples;

import org.springframework.beans.factory.annotation.Value;

public class Address {

    @Value("${addressName:Rayachoty}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
