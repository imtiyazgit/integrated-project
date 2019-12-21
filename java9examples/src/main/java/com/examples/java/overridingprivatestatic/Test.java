package com.examples.java.overridingprivatestatic;

public class Test {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        //v.getX() // You can not access
        System.out.println(v.getStaticY());
    }
}
