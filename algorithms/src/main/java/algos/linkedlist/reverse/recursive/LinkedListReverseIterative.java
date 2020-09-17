package algos.linkedlist.reverse.recursive;

public class LinkedListReverseIterative {


    //     1->2->3->4->5->null
    //   null <- 1 <-2
    public static ListNode reverse(ListNode head) {
        ListNode prev= null;
        ListNode current = head;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode rev = reverse(head);
        System.out.println(rev);
    }
}
