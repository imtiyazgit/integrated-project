package algos.linkedlist.pivot;

public class PivotLinkedList {

    /**
     * 3 2 2 11 7 5 11
     *
     *  if x is 7
     *
     *  Output 3 2 2 5 7 11 11
     *  lessHead at -1->3->2->2->5, use lessIter to move to next element
     *  equalHead at -1->7, use equaliter
     *  greaterHead at -1->11->11, use greateriter
     */
    public static ListNode pivotElements(ListNode head, int x) {
        ListNode greaterHead = new ListNode(-1, null);
        ListNode equalHead = new ListNode(-1, null);
        ListNode lessHead = new ListNode(-1, null);

        ListNode greaterIter = greaterHead;
        ListNode equalIter = equalHead;
        ListNode lessIter = lessHead;

        ListNode currentNode = head;
        while(currentNode != null) {
            if (currentNode.data > x) {
                greaterIter.next = currentNode;
                greaterIter = greaterIter.next ;
            } else if (currentNode.data == x) {
                equalIter.next = currentNode;
                equalIter = equalIter.next;
            } else {
                lessIter.next = currentNode;
                lessIter = lessIter.next;
            }

            currentNode = currentNode.next;
        }

        greaterIter.next = null;
        equalIter.next = greaterHead.next;
        lessIter.next = equalHead.next;

        return lessHead.next;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(new ListNode(3));
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(11));
        linkedList.insert(new ListNode(7));
        linkedList.insert(new ListNode(5));
        linkedList.insert(new ListNode(11));

        ListNode head = pivotElements(linkedList.head, 7);
        System.out.println(head);

    }
}
