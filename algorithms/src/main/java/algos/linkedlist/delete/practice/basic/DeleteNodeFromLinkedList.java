package algos.linkedlist.delete.practice.basic;

public class DeleteNodeFromLinkedList {

    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    static class LinkedList {
        ListNode head;

        public void insertNode(ListNode newNode) {
            if (head == null) {
                head = newNode;
            } else {
                ListNode currentNode = head;
                while(currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = newNode;
            }
        }

        public void delete(ListNode node) {
            ListNode currentNode = head;

            while(currentNode != null && currentNode.next != null && currentNode.next.data != node.data) {
                currentNode = currentNode.next;
            }

            currentNode.next = currentNode.next.next;
        }

        // Below solution can delete given node.. Node must not be a tail node since it replaces itself by next node
        public void deleteUsingSuccessorTechnique(ListNode node) {
            node.data = node.next.data;
            node.next = node.next.next;
        }

        // 1->2->3->4->5
        // K is 2, 1->2->3->5
        public ListNode removeKthLast(ListNode head, int k) {
            ListNode dummyHead = new ListNode(-1, head);
            ListNode fast = head;
            ListNode slow = head;

            while(k-->=0) {
                // Move fast by k steps.. This will be at the exact node which will be deleted
                fast = fast.next;
            }

            // Now advance both fast and slow in tandem by one until fast is null
            while(fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // Now slow is exactly at the previous node using which you can delete its next node
            slow.next = slow.next.next;
            return dummyHead.next;
        }
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertNode(new ListNode(1));
        linkedList.insertNode(new ListNode(2));
        ListNode nodeToBeDeleted = new ListNode(3);
        linkedList.insertNode(nodeToBeDeleted);
        linkedList.insertNode(new ListNode(4));
        linkedList.insertNode(new ListNode(5));
        linkedList.insertNode(new ListNode(6));
        linkedList.insertNode(new ListNode(7));
        linkedList.insertNode(new ListNode(8));
        linkedList.insertNode(new ListNode(9));

        //linkedList.delete(nodeToBeDeleted);
        //linkedList.deleteUsingSuccessorTechnique(nodeToBeDeleted);

        ListNode headNode = linkedList.removeKthLast(linkedList.head, 2);
        System.out.println("all done");

    }
}
