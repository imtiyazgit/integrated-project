package com.concurrency.synchronizers;

// Lets play a race game
// All athlets will start running once gun shot hears
// Each athlet will run to its end.
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class MyAthlet extends Thread {
    private String name;
    private CyclicBarrier barrier;
    public MyAthlet(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }
    public void run() {
        System.out.println(name +" is awaiting...");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + " is broken...");
        System.out.println(name + " is done!");
    }
}

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("All threads reached at barrier point...");
            }
        });
        MyAthlet a1 = new MyAthlet("Imtiyaz", barrier);
        MyAthlet a2 = new MyAthlet("Peera", barrier);
        MyAthlet a3 = new MyAthlet("Jyoti", barrier);
        a1.start();
        a2.start();
        a3.start();
        System.out.println("Main done");
    }
}
