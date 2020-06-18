package algos.stack.maxApi.practice;

import java.util.ArrayDeque;

public class Stack {
    ArrayDeque<ElementMaxPair> dequeue = new ArrayDeque<>();

    public boolean empty() {
        return dequeue.isEmpty();
    }

    public Integer pop() {
        return dequeue.removeFirst().element;
    }

    public void push(int element) {
        int max = dequeue.isEmpty() ? element: Math.max(element, dequeue.peek().max);

        dequeue.addFirst(new ElementMaxPair(element, max));
    }

    public Integer max() {
        return dequeue.peek().max;
    }
}
