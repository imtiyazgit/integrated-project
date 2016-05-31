package com.concurrency.basics;

class MyThread extends Thread {
    public void run() {
        throw new RuntimeException("Unknown exception");
    }
}
public class UncaughtExceptionFromThread {
    public static void main(String[] args) {
        Thread t = new MyThread();
        /*t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("uncaught exception is "+e);
            }
        });*/
        t.start();

    }
}
