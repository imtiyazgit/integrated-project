package algos.linkedlist.reverse;

public class LinkedListReversePT {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(new ListNode(1));
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(3));
        linkedList.insert(new ListNode(4));
        linkedList.insert(new ListNode(5));

        linkedList.printReverse(linkedList.head);
        System.out.println("all done");


    }

    static class LinkedList {
        ListNode head;

        public void insert(ListNode newNode) {
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

        // 1
        // 2
        // 3
        // 4
        // 5
        // null -- null will be sent to printReverse function which is the base condition for recursive loop to exit
        private static void printReverse(ListNode node) {
            if(node == null) {
                return;
            }

            printReverse(node.next);
            System.out.println(node.data);
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
