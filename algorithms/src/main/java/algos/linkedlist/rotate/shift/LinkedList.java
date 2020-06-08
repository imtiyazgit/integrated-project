package algos.linkedlist.rotate.shift;

public class LinkedList {
    ListNode head;

    public void insert(ListNode newNode) {
        if(head == null) {
            head = newNode;
        } else {
            ListNode currentNode = head;

            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }
    }
}
