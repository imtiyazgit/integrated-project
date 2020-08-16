package algos.queue.implementation.queueusingstack.pt;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *   2 3 4 deque 5 6 7
 *
 *  solve:
 *  enqueStack -- O(1)
 *  4
 *  3
 *  2
 *
 *  dequeStack - when a deque operation called, 2 should be deleted, trasfer all eelements from enque stack and remove the top most element - O(n)
 * 2
 * 3
 * 4
 * we will remove the top most element..
 * 3
 * 4
 */
public class QueueUsingStack {
    Deque<Integer> enqueueStack = new ArrayDeque<>();
    Deque<Integer> dequeStack = new ArrayDeque<>();

    public void enqueue(Integer element) {
        enqueueStack.addFirst(element);
    }

    public Integer deque() {
        if(dequeStack.isEmpty()) {
            // transfer all elements from enqueueStack
            while(!enqueueStack.isEmpty()) {
                dequeStack.addFirst(enqueueStack.removeFirst());
            }
        }
        return dequeStack.removeFirst();
    }

}
