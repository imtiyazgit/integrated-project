package algos.linkedlist.mergeKsortedlists;

import java.util.PriorityQueue;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>  minHeap = new PriorityQueue<>((a,b) -> a.data - b.data);

        for(ListNode listNode:lists) {
            ListNode header = listNode;
            while(header != null) {
                minHeap.add(header);
                header = header.next;
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode header = dummyNode;
        while(!minHeap.isEmpty()) {
            header.next = minHeap.remove();
            header = header.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next =  new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] input = new ListNode[] {list1, list2, list3};

        ListNode result = mergeKLists(input);
        ListNode current = result;

        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }

    }
}
