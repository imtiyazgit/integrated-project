package com.imtiyaz.examples;

/**
 * Created by sg0222221 on 11/11/2015.
 */
public class OrderFailedException extends Exception {
    private static final long serialVersionUID = 6046320314876333963L;

    public OrderFailedException(String s) {
        super(s);
    }

    public OrderFailedException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
