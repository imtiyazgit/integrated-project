package com.concurrency.synchronizers;

import java.util.concurrent.CountDownLatch;

class Athlet extends Thread {
    private int id;
    private CountDownLatch cdl;
    public Athlet(int id, CountDownLatch cdl) {
        this.cdl = cdl;
        this.id = id;
    }
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("Athlet-" + id + " has completed his run");
            cdl.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(3);
        Athlet athlet1 = new Athlet(1, cdl);
        Athlet athlet2 = new Athlet(2, cdl);
        Athlet athlet3 = new Athlet(3, cdl);

        athlet1.start();
        athlet2.start();
        athlet3.start();

        System.out.println("Main thread is waiting for runners to complete");
        cdl.await();

        System.out.println("Now main thread is also complete");

    }
}
