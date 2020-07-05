package algos.queue.implementation.circularqueue;

import java.util.NoSuchElementException;

public class CircularQueue {
    private int[] array;
    private int front, rear;
    private int size;

    public CircularQueue(int initialSize) {
        this.array = new int[initialSize];
        this.front = this.rear = -1;
        size = 0;
    }

    public void enqueue(int data) {
        if(isFull()) {
            resize();
        } else if(isEmpty()) {
            front++;
        }

        rear = rear+1 % array.length;
        array[rear] = data;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int dequeuedElement = array[front];
        if(front == rear) {
            front = rear = -1;
        }
        front = (front+1) % array.length;
        size--;
        return dequeuedElement;
    }

    public boolean isFull() {
        return (rear+1) %array.length == front;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void resize() {
        int[] tempArr = new int[array.length*2];
        int i=0;
        int j=front;

        do {
            tempArr[i++] = array[j];
            j = (j+1) % array.length;
        } while (j != front);

        front = 0;
        rear = array.length - 1;
        array = tempArr;
    }

    public int peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        return array[front];
    }

    public int getSize() {
        return size;
    }
}
