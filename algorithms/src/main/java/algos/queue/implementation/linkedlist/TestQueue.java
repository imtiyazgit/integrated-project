package algos.queue.implementation.linkedlist;

public class TestQueue {

    public static void main(String[] args) {
        QueueImplementationUsingLinkedList queue = new QueueImplementationUsingLinkedList();
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);

        System.out.println(queue.peek().data);
        System.out.println(queue.getSize());

        System.out.println(queue.dequeue().data);
        System.out.println(queue.dequeue().data);

        System.out.println(queue.peek().data);
        System.out.println(queue.getSize());

    }
}
