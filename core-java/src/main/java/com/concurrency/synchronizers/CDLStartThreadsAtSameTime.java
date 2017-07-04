package main.java.com.concurrency.synchronizers;

import java.util.concurrent.CountDownLatch;

class ObjectFactory {
    private volatile Object object;
    public Object getInstance() {
        if (object == null) {
            synchronized(this) {
                if (object == null) {
                    object = new Object();
                }
            }
        }
        return object;
    }
}

class MyThread extends Thread {
    Object instance;
    ObjectFactory objectFactory;
    CountDownLatch startSignal;
    MyThread(ObjectFactory objectFactory, CountDownLatch latch) {
        this.objectFactory = objectFactory;
        this.startSignal = latch;
    }
    public void run() {
        try {
            startSignal.await();
            instance = objectFactory.getInstance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Object getInstance() {
        return instance;
    }
}

public class CDLStartThreadsAtSameTime {
    public static void main(String[] args) throws InterruptedException {
        final ObjectFactory objectFactory = new ObjectFactory();
        final CountDownLatch startSignal = new CountDownLatch(1);

        MyThread[] threads = new MyThread[1000];
        for (int i=0; i<1000;i++) {
            threads[i] = new MyThread(objectFactory, startSignal);
            threads[i].start();
        }

        startSignal.countDown();

        for (MyThread thread:threads) {
            thread.join();
        }

        Object instance = objectFactory.getInstance();
        for (MyThread thread:threads) {
            System.out.println(instance == thread.getInstance());
        }

    }


}
