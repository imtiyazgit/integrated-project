package algos.queue.implementation.linkedlist.pt;

public class QueueImplementationUsingLinkedList {
    ListNode front;
    ListNode rear;
    int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public ListNode enqueue(int element) {
        ListNode newNode = new ListNode(element);

        // enequeue should be at the rear end
        if (isEmpty()) {
            // queue is empty
            rear = newNode;
            front = newNode;
            size++;
            return newNode;
        } else {
            // queue is not empty
            rear.next = newNode;
            rear = rear.next;
            size++;
            return newNode;
        }
    }

    public ListNode dequeue() {
        if(isEmpty()) {
            return null;
        }
        // you have queue elements, and you need to dequeue using front
        if (front.next == null) {
            // you have only one element
            ListNode deletedNode = new ListNode(front.data);
            front = null;
            rear = null;
            size--;
            return deletedNode;
        } else {
            // you have next element as well
            ListNode deletedNode = new ListNode(front.data);
            front = front.next;
            size--;
            return deletedNode;
        }
    }

    public ListNode peek() {
        if(isEmpty()) {
            return null;
        }

        ListNode peekNode = new ListNode(front.data);
        return peekNode;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        QueueImplementationUsingLinkedList queue = new QueueImplementationUsingLinkedList();
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);

        System.out.println(queue.peek().data);
        System.out.println(queue.getSize());

        System.out.println(queue.dequeue().data);
        System.out.println(queue.dequeue().data);

        System.out.println(queue.peek().data);
        System.out.println(queue.getSize());
    }
}
