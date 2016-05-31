package com.concurrency.threadpool;

import java.util.concurrent.*;
// Executor service is a thread pool
// You can submit tasks like Runnable/Callable or execute Runnable
// These runs in parallel in the background
// Represents asynchronous execution mechanism
public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task completed");
            }
        });

        System.out.println("Task1 completed");
        Future future = executorService.submit(new Callable() {
            @Override
            public Object call() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task completed");
                return "Callresult";
            }
        });
        System.out.println("Result="+future.get());
        executorService.shutdown();
    }
}
