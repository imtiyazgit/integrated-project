package algos.queue.implementation.usingarray;

public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enque(200);
        arrayQueue.enque(300);
        arrayQueue.enque(400);
        arrayQueue.enque(500);
        arrayQueue.enque(600);
        arrayQueue.enque(600);

        System.out.println(arrayQueue.peek());
        arrayQueue.deque();
        arrayQueue.deque();
        arrayQueue.deque();
        arrayQueue.deque();
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.getSize());

    }
}
