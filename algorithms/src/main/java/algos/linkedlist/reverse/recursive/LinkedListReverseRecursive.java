package algos.linkedlist.reverse.recursive;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}
public class LinkedListReverseRecursive {


    // 1->2->3->4->5->null
    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // when you are at 4, you provide 5 to recursion
        ListNode reversedList = reverse(head.next);

        // 1->2->3->4->(arrow2)5->(arrow1)null
        // arrow1 i.e 5's next should be pointing to 4
        // To access 5's next, you are at 4 i.e. head.. Therefore, head.next.next ->point to itself i.e. 4
        head.next.next = head;
        head.next = null; // you dont need next pointer to 5
        return reversedList;
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
