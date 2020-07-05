package algos.queue.implementation.circularqueue;

public class TestCircularQueue {
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.enqueue(21);
        circularQueue.enqueue(22);
        circularQueue.enqueue(23);
        circularQueue.enqueue(24);
        circularQueue.enqueue(25);

        System.out.println(circularQueue.peek());

        circularQueue.dequeue();

        System.out.println(circularQueue.peek());

        System.out.println(circularQueue.getSize());

    }
}
