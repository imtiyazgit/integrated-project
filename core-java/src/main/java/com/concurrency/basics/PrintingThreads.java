package com.concurrency.basics;

class PrintingThread implements Runnable {

    String name;

    public PrintingThread(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Thread "+name +" going to sleep");
        try {
            Thread.sleep(180000);
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }
}

public class PrintingThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintingThread("T1"));
        Thread t2 = new Thread(new PrintingThread("T2"));
        Thread t3 = new Thread(new PrintingThread("T3"));
        Thread t4 = new Thread(new PrintingThread("T34"));



        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");
        t4.setName("T4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
