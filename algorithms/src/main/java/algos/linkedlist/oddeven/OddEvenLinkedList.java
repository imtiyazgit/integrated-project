package algos.linkedlist.oddeven;

public class OddEvenLinkedList {

    // 1->2->3->4->5->6->null
    // Result: 1->3->5->2->4->6->null

    // Input: 2->1->4->6->3->5>null
    //        1  2  3  4  5  6
    // Output:2->4->3->1->6->5>null
    private static ListNode moveNodesOddEven(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode odd = oddHead;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(1));
        linkedList.insert(new ListNode(4));
        linkedList.insert(new ListNode(6));
        linkedList.insert(new ListNode(3));
        linkedList.insert(new ListNode(5));

        ListNode head = moveNodesOddEven(linkedList.head);

        System.out.println("all done");
    }
}
