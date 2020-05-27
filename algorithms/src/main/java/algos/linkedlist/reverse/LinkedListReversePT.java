package algos.linkedlist.reverse;

public class LinkedListReversePT {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(new ListNode(1));
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(3));
        linkedList.insert(new ListNode(4));
        linkedList.insert(new ListNode(5));

        ListNode result = linkedList.reverseSublist(linkedList.head, 2, 4);

       /* linkedList.printReverse(linkedList.head);

        ListNode head = linkedList.reverse(linkedList.head);*/
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

        // 1->2->3->4->5 -> null
        // 1->2<-3<-4->5->null Reversing next elements between 2,3 and 4
        // 1->4->3->2->5->null Adjust 1's pointer and 2's pointer
        private static ListNode reverseSublist(ListNode head, int m, int n) {

            ListNode prev = null;
            ListNode currentNode = head;

            while(m>1) {
                prev = currentNode;
                currentNode = currentNode.next;
                m--;
                n--;
            }

            ListNode connectionNodeToSublist = prev; // which is 1
            ListNode tailNodeOfSublist = currentNode; // which is 2

            while(n>0) {
                ListNode next = currentNode.next;
                currentNode.next = prev;
                prev = currentNode  ;
                currentNode = next;
                n--;
            }

            // State current node is at 5. Prev is the head of sublist i.e 4.
            // set connection node to 4 i.e. prev
            if(connectionNodeToSublist != null) {
                connectionNodeToSublist.next=prev;
            }

            // set tail node of sublist to current node i.e. 5
            tailNodeOfSublist.next = currentNode;

            return head;
        }

        // 1->2>3>null
        // null<-1 <- 2 <- 3
        private static ListNode reverse(ListNode head) {
            ListNode prev = null;

            while(head != null) {
                // Since head's next variable is used to move forward and also we are updating it, store it in local variable
                ListNode next = head.next;

                // Set 1's next to prev null
                head.next = prev;

                // Once next element is pointed to prev, set prev to the current head
                prev = head;

                // Move head to the next element using the local variable. do not use head.next since its already pointed backwards
                head = next;
            }

            // ALWAYS RETURN PREV.. HEAD IS NULL
            return prev;
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
