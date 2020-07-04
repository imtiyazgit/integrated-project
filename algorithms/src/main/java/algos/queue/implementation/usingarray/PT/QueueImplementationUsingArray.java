package algos.queue.implementation.usingarray.PT;

public class QueueImplementationUsingArray {
    private int[] array;
    private int rear;
    private int front;
    private int size;

    public QueueImplementationUsingArray(int arraySize) {
        this.array = new int[arraySize];
        rear = -1;
        front = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size==0;
    }

    // 22   33      44
    // front        rear
    public boolean enqueue(int element) {
        if (rear+1 == array.length) {
            return false;
        }
        rear++;
        array[rear] = element;
        size++;
        return true;
    }

    public int deque() {
        if (!isEmpty()) {
            front++;
            size--;
            return array[front];
        }
        return -1;
    }

    public int peek() {
        if(!isEmpty()) {
            return array[front+1];
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        QueueImplementationUsingArray queue = new QueueImplementationUsingArray(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        System.out.println(queue.getSize());

        System.out.println(queue.deque());
        System.out.println(queue.peek());
    }
}
