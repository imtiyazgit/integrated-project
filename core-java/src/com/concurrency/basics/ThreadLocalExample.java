package com.concurrency.basics;

// Two threads execute the shared task and run method would be executed 2 times one for each
// threadlocal.set would not override first thread's value.
// So, value is independent for each thread
class SharedTask implements Runnable {
    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public void run() {
        threadLocal.set((int) (Math.random() * 100D));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println(threadLocal.get());
    }
}

public class ThreadLocalExample {
    public static void main(String[] args) {
        SharedTask sharedTask = new SharedTask();
        new Thread(sharedTask).start();
        new Thread(sharedTask).start();
    }
}

