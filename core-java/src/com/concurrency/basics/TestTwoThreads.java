package com.concurrency.basics;


public class TestTwoThreads {

    static int i=0;

    class Thread1 implements Runnable {
        public void run() {
            i++;
        }
    }

    class Thread2 implements Runnable {
        public void run() {
            System.out.println(i);
        }
    }

    public void print() throws InterruptedException {
        Thread1 t1 = new Thread1();
        new Thread(t1).start();

        Thread.sleep(10000);

        Thread2 t2 = new Thread2();
        new Thread(t2).start();

    }

    public static void main(String[] args) throws InterruptedException {
        new TestTwoThreads().print();
    }

}
