package main.java.com.concurrency.deadlock;

class MyThread extends Thread {
    Object obj1;
    Object obj2;

    MyThread(String name, Object obj1, Object obj2) {
        super(name);
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " Acquiring lock on "+obj1);
        synchronized (obj1) {
            System.out.println(name + " Acquired lock on "+obj1);
            work();
            System.out.println(name + " Acquiring lock on "+obj2);
            synchronized (obj2) {
                System.out.println(name + " Acquired lock on "+obj2);
                work();
            }
        }
    }

    private void work() {
        try {
            Thread.sleep(30000);
            System.out.println(Thread.currentThread().getName() + " sleep for 30 sec over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class DeadLockExample {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        new MyThread("t1", obj1, obj2).start();
        new MyThread("t2", obj2, obj3).start();
        new MyThread("t3", obj3, obj1).start();



    }
}


