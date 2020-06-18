package algos.stack.maxApi;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack {
    Deque<ElementMaxPair> deque = new ArrayDeque<>();
    //Integer currentMax;

    public void push(Integer element) {
        /*currentMax = currentMax == null || element > currentMax ? element : currentMax;
        deque.addFirst(new ElementMaxPair(element, currentMax));*/
        int max = deque.isEmpty() ? element : Math.max(element, deque.peek().max);
        deque.addFirst(new ElementMaxPair(element, max));
    }

    public void pop() {
        if(deque.isEmpty()) {
            return;
        }
        deque.removeFirst();
    }

    // So, max now is straight forward i.e. constant time O(1)
    public Integer max() {
        return deque.peek().max;
    }
}
