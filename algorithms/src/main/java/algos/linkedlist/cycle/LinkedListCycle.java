package algos.linkedlist.cycle;

/**
 *  1->2->3
 *     ^  |
 *     5<-4
 *
 *   Linked list has cycle 3 points to 4, 4 points to 5, 5 points to 2 which is a cycle. Detect this
 *
 */

public class LinkedListCycle {

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
    }

    private static boolean hasCycle(ListNode head) {
        // slow moves by 1 and starts with head
        ListNode slow = head;

        // fast moves by 2 and starts with head
        ListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }

        }

        return false;
    }

    private static ListNode cycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // cycle found
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;

            }
        }
        return null;
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(new ListNode(1));
        ListNode loopNode = new ListNode(2);
        linkedList.insert(loopNode);
        linkedList.insert(new ListNode(3));
        linkedList.insert(new ListNode(4));
        linkedList.insert(new ListNode(5));
        linkedList.insert(loopNode);

        System.out.println(hasCycle(linkedList.head));

        ListNode cycleStart = cycleStart(linkedList.head);
        System.out.println(cycleStart);

    }




}
