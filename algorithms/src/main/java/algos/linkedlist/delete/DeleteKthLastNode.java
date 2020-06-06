package algos.linkedlist.delete;

/**
 * 1->2->3->4->5->6->7->8->9->null
 *
 * K is 2, then 1->2->3->4->5->6->7->9
 */
public class DeleteKthLastNode {

    private static ListNode deleteKthNodeFromLast(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = head;

        // advance fast by k steps
        while (k-->=0) {
            fast = fast.next;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(new ListNode(1));
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(3));
        linkedList.insert(new ListNode(4));
        linkedList.insert(new ListNode(5));
        linkedList.insert(new ListNode(6));
        linkedList.insert(new ListNode(7));
        linkedList.insert(new ListNode(8));
        linkedList.insert(new ListNode(9));

        ListNode headNode = deleteKthNodeFromLast(linkedList.head, 2);

        System.out.println("all done");

    }


}
