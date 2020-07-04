package algos.queue.implementation.usingarray;

public class ArrayQueue {

    private int[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int sizeOfArray) {
        this.array = new int[sizeOfArray];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean enque(int element) {
        if (rear+1 < array.length) {
            rear++;
            array[rear] = element;
            size++;
            return true;
        }
        return false;
    }

    public int deque() {
        if(size ==0) {
            return -1;
        }
        front++;
        size--;
        return array[front];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if(!isEmpty()) {
            return array[front+1];
        }
        return -1;
    }
}
