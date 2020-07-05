package algos.queue.implementation.linkedlist;

public class QueueImplementationUsingLinkedList {
    ListNode front;
    ListNode rear;
    int size;

    public ListNode enqueue(int data) {
                // enqueue at rear side
        ListNode newNode = new ListNode(data);

        if(front == null) {
            // there are no elements in the queue
            rear = newNode;
            front = rear;
        } else {
            // there are elements in the queue
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        return newNode;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public ListNode dequeue() {
        if(isEmpty()) {
            return null;
        } else{
            // there are elements which could be one or two or more
            if(front.next == null) {
                // only one element
                ListNode deletedNode = new ListNode(front.data);
                front = null;
                rear = null;
                size--;
                return deletedNode;
            } else {
                // next element also available
                ListNode deletedNode = new ListNode(front.data);
                front = front.next;
                size--;
                return deletedNode;
            }
        }
    }

    public ListNode peek() {
        if(isEmpty()) {
            return null;
        } else {
            ListNode peekNode = new ListNode(front.data);
            return peekNode;
        }
    }

    public int getSize() {
        return size;
    }
}
