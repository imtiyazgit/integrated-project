package algos.linkedlist.addtwonumbers;

public class AddTwoNumbersLinkedListSol {

    // 413 + 907 = 1320
    // 3->1->4 + 7->0->9 = 0->2->3->1
    // 3 and 7, 0 and carry is 1
    // 1 and 0 with carry as 1, 2 is the result, carry is 0
    // 4 and 9 with carry as 0, 13 is the result. 3 in the place and 1 as carry forward
    // finally null and null with carry as 1 and we will add 1 as node to the result linked list
    public static ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        ListNode dummyHead = new ListNode(-1, null);
        ListNode dummyHeadIter = dummyHead;
        int carry = 0;

        while (L1 != null || L2 != null || carry != 0) {
            int placeVal = carry + (L1 != null ? L1.data : 0) + (L2 != null ? L2.data : 0);
            ListNode placeValNode = new ListNode(placeVal%10);
            dummyHeadIter.next = placeValNode;
            dummyHeadIter = dummyHeadIter.next;

            carry = placeVal/10;
            L1 = L1 != null ? L1.next : null;
            L2 = L2 != null ? L2.next : null;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.insert(new ListNode(3));
        linkedList1.insert(new ListNode(1));
        linkedList1.insert(new ListNode(4));

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insert(new ListNode(7));
        linkedList2.insert(new ListNode(0));
        linkedList2.insert(new ListNode(9));

        ListNode head = addTwoNumbers(linkedList1.head, linkedList2.head);

        System.out.println(head);

    }
}
