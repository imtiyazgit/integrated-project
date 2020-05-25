package algos.linkedlist.mergetwosortedlists;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        // 1->2->4->6
        LinkedList linkedList1 = new LinkedList();
        linkedList1.insert(new ListNode(1));
        linkedList1.insert(new ListNode(2));
        linkedList1.insert(new ListNode(4));
        linkedList1.insert(new ListNode(6));

        // 3->5
        LinkedList linkedList2 = new LinkedList();
        linkedList2.insert(new ListNode(3));
        linkedList2.insert(new ListNode(5));

        System.out.println(linkedList1);
        System.out.println(linkedList2);


        ListNode result = merge(linkedList1.header, linkedList2.header);
        System.out.println("done");


    }

    // 1->2->4->6
    // 3->5
    // Space Complexity: You are using existing nodes to create new linked list: O(1)
    // Time complxity: O(m+n) as you are iterating over m and n of the lists
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;

        while(l1 != null && l2 != null) {

            if(l1.data < l2.data) {
                dummyNode.next = l1;
                l1 = l1.next;
            } else {
                dummyNode.next = l2;
                l2 = l2.next;
            }

            dummyNode = dummyNode.next;
        }

        if(l1 != null) {
            dummyNode = l1; // next elements of l1 are sorted and linked automaticaly. You dont need to write this in while loop
        }

        if(l2 != null) {
            dummyNode = l2;
        }

        return head.next;
    }


    static class LinkedList {
        ListNode header;

        public ListNode insert(ListNode node) {
            if(header == null) {
                header = node;
            } else {
                ListNode currentNode = header;
                while(currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = node;
            }

            return header;

        }
    }


    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }
}
