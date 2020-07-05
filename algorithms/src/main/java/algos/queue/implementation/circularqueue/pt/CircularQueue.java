package algos.queue.implementation.circularqueue.pt;

import java.util.Arrays;
import java.util.NoSuchElementException;

//   2 3 4 5 6
// after dequeuing 2 and 3 elements
//   2 3    4 5 6-> rear
//       front
public class CircularQueue {

    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int arrInitialSize) {
        this.arr = new int[arrInitialSize];
        front = rear = -1;
        size =0;
    }

    public void enqueue(int data) {
        if(isFull()) {
            int[] newArr = Arrays.copyOf(arr, arr.length*2);
            front = 0;
            rear = arr.length -1;
            arr = newArr;
        } else if(isEmpty()) {
            front++;
        }
        rear= (rear+1) % arr.length;
        arr[rear] = data;
        size++;
    }

    public int dequeue() {
        if(isEmpty()) throw new NoSuchElementException();
        int temp = arr[front];
        front = (front+1) % arr.length;
        size--;
        return temp;
    }

    public int peek() {
        if(isEmpty()) throw new NoSuchElementException();
        return arr[front];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear+1) % arr.length == front;
    }

    public int getSize() {
        return size;
    }
}
