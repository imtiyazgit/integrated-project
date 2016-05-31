package com.concurrency.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

class Task1 implements Runnable {
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("processed task1");
    }
}

class Task2 implements Runnable {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("processed task2");
    }
}

class Task3 implements Runnable {
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("processed task3");
    }
}

class WorkerThread extends Thread {
    private boolean isStopped;
    private ArrayBlockingQueue<Runnable> taskQueue;

    WorkerThread(ArrayBlockingQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void run() {
        while (!isStopped) {
            Runnable runnable = null;
            try {
                runnable = taskQueue.take();
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        isStopped = true;
    }
}
public class SimpleThreadPool {
    private List<WorkerThread> workerThreads;
    private ArrayBlockingQueue taskQueue;
    private boolean isStopped = false;

    public SimpleThreadPool(int maxNoOfThreads, int maxNoOfTasks) {
        workerThreads = new ArrayList<WorkerThread>(maxNoOfThreads);
        taskQueue = new ArrayBlockingQueue(maxNoOfTasks);

        for (int i=0;i<maxNoOfThreads;i++) {
            workerThreads.add(new WorkerThread(taskQueue));
        }

        for (WorkerThread thread:workerThreads) {
            thread.start();
        }
    }

    public synchronized void execute(Runnable runnable) throws InterruptedException {
        if (isStopped) {
            throw new IllegalStateException("Thread pool is stopped");
        }
        taskQueue.put(runnable); // blocking put, waits if full
    }

    public synchronized void stop() {
        isStopped = true;
        for (WorkerThread thread:workerThreads) {
            thread.stopThread();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();

        SimpleThreadPool threadPool = new SimpleThreadPool(2, 2);
        int taskCount = 0;
        while (taskCount<50) {
            Random random = new Random();
            int n= random.nextInt(3);
            if (n==0) { threadPool.execute(task1);}
            if (n==1) { threadPool.execute(task2);}
            if (n==2) { threadPool.execute(task3);}
            taskCount++;
            Thread.sleep(50);
        }
    }

}
