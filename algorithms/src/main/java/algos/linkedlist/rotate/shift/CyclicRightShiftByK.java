package algos.linkedlist.rotate.shift;

/**
 * 2->3->5->3->2->null
 *
 * K= 3
 *
 * 5->3->2->2->3->null
 *
 */

public class CyclicRightShiftByK {

    private static ListNode cyclicRightShiftByK(ListNode head, int k) {
        if(head == null || k<1) {
            return head;
        }

        // Step1: Find tail node
        ListNode tail = head;
        int n=1;
        while(tail.next != null) {
            ++n;
            tail = tail.next;
        }

        k = k%n;

        if (k==0) {
            return head;
        }

        int stepsToMove = n-k;
        tail.next = head;
        ListNode newTail = tail;

        while(stepsToMove-- > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(3));
        linkedList.insert(new ListNode(5));
        linkedList.insert(new ListNode(3));
        linkedList.insert(new ListNode(2));

        ListNode newHead = cyclicRightShiftByK(linkedList.head, 3);
        System.out.println("all done");
    }
}
