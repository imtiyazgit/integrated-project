package algos.linkedlist.delete;

/**
 * 1->2->3->4>5>null
 */
public class DeleteANode {

    // Assumes nodeToBeDeleted is not a tail node
    // Time Complexity: O(1)
    private static void delete(ListNode nodeToBeDeleted) {
        nodeToBeDeleted.data = nodeToBeDeleted.next.data;
        nodeToBeDeleted.next = nodeToBeDeleted.next.next;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        ListNode node1 = new ListNode(1);
        linkedList.insert(node1);
        linkedList.insert(new ListNode(2));

        ListNode node3 = new ListNode(3);
        linkedList.insert(node3);

        linkedList.insert(new ListNode(4));

        ListNode node5 = new ListNode(5);
        linkedList.insert(node5);

        delete(node3);

        System.out.println("all done");

    }
}
