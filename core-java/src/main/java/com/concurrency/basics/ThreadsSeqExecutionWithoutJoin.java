package main.java.com.concurrency.basics;

class JoinTask {
    private int currentTask = 1;
    public void doTask(int task, String message) {
        synchronized (this) {
            while (task != currentTask) {
                try {
                    wait();
                } catch(Exception e) {}
            }
        }
        System.out.println("Task "+task +" is done");
        currentTask++;
    }
}
public class ThreadsSeqExecutionWithoutJoin {
    public static void main(String[] args) {
        final JoinTask joinTask = new JoinTask();
        new Thread() {
            public void run() {
                joinTask.doTask(1, "FirstThread");
            }
        }.start();

        new Thread() {
            public void run() {
                joinTask.doTask(2, "SecondThread");
            }
        }.start();

        new Thread() {
            public void run() {
                joinTask.doTask(3, "ThreeThread");
            }
        }.start();
    }
}
