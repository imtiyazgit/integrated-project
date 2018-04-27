package com.generics;

public class Dog extends Animal {

    public Dog(String name, int legs) {
        super(name, legs);
    }

    @Override
    public int getLegs() {
        return 4;
    }
}
