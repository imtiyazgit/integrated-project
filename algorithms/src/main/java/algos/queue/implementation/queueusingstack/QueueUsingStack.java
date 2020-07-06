package algos.queue.implementation.queueusingstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingStack {
    private Deque<Integer> enqueue = new ArrayDeque<>();
    private Deque<Integer> dequeue = new ArrayDeque<>();

    public void enqueue(int data) {
        enqueue.addFirst(data);
    }

    public int dequeue() {
        if(dequeue.isEmpty()) {
            // transfer elements from stack1
            while(!enqueue.isEmpty()) {
                dequeue.addFirst(enqueue.removeFirst());
            }
        }

        return dequeue.removeFirst();
    }


}
