package algos.queue.implementation.queueusingstack.pt;

public class TestQueue {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);

        queue.deque();
        queue.deque();
        queue.deque();

        queue.enqueue(9);

        System.out.printf("all done");
    }
}
