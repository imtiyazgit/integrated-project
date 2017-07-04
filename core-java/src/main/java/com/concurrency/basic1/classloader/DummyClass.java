package main.java.com.concurrency.basic1.classloader;

public class DummyClass {
    private static final String tst ="Imtiyaz";

    public void print(String arg) {
        System.out.println(tst);
        System.out.println("and arg is "+arg);
    }
}
