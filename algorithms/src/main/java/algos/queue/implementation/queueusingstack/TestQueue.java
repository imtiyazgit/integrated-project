package algos.queue.implementation.queueusingstack;

public class TestQueue {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(9);

        System.out.printf("all done");
    }
}
