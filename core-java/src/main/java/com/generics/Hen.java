package com.generics;

public class Hen extends Animal {

    public Hen(String name, int legs) {
        super(name, legs);
    }

    @Override
    public int getLegs() {
        return 2;
    }
}
