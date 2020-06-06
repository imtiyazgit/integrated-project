package algos.linkedlist.delete;

public class RemoveDuplicatesFromSortedLinkedList {

    // 2->2->2->2->3->5->7->11->11->null
    // Time complexity: O(n)
    private static void removeDuplicatesFromSortedLinkedList(ListNode head) {
        ListNode currentNode = head;
        while(currentNode != null) {

            while(currentNode.next != null && currentNode.data == currentNode.next.data) {
                currentNode.next = currentNode.next.next;
            }

            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(3));
        linkedList.insert(new ListNode(5));
        linkedList.insert(new ListNode(7));
        linkedList.insert(new ListNode(11));
        linkedList.insert(new ListNode(11));

        removeDuplicatesFromSortedLinkedList(linkedList.head);

        System.out.printf("all done");
    }


}
