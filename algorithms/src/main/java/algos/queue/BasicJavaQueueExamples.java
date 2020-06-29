package algos.queue;

import java.util.*;

public class BasicJavaQueueExamples {

    public static void main4(String[] args) {
        Queue<Integer> queueOfIntegers = new LinkedList<>();
        queueOfIntegers.add(3);
        queueOfIntegers.poll();
        queueOfIntegers.poll();
        queueOfIntegers.poll();
    }

    public static void main3(String[] args) {
        Deque<Integer> dequeOfIntegers = new LinkedList<>();
        dequeOfIntegers.addFirst(2);
        dequeOfIntegers.addFirst(99);
        dequeOfIntegers.addFirst(33);
        dequeOfIntegers.addLast(7);
        dequeOfIntegers.addLast(156);
        // 33 99 2 7 156

        System.out.println(dequeOfIntegers.peekFirst());
        System.out.println(dequeOfIntegers.peekLast());

        dequeOfIntegers.push(78);
        System.out.println(dequeOfIntegers.peekFirst());

        dequeOfIntegers.pop();
        System.out.println(dequeOfIntegers.peekFirst());
    }

    public static void main(String[] args) {
        Queue<Integer> queueOfIntegers = new ArrayDeque<>();
        //Queue<Integer> queueOfIntegers = new LinkedList<>();
        queueOfIntegers.add(2);
        queueOfIntegers.add(3);
        queueOfIntegers.add(4);

        // 2 3 4
        System.out.println(queueOfIntegers.peek());

        queueOfIntegers.remove();

        System.out.println(queueOfIntegers.peek());

    }
}
