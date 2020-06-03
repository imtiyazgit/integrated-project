package algos.linkedlist.YProblemOrIntersectionOrOverlapping;

/**
 * 1->2->3->4->5->6->7->null
 *             ^
 *       8->9 -|
 */

public class FindIntersection {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    static class LinkedList {
        Node head;

        public void insert(Node newNode) {
            if (head == null) {
                head = newNode;
            } else {
                Node currentNode = head;
                while(currentNode.next != null) {
                    currentNode = currentNode.next;
                }

                currentNode.next = newNode;

            }
        }

        public int length() {
            Node currentNode = head;
            int length=0;
            while(currentNode != null) {
                ++length;
                currentNode = currentNode.next;
            }
            return length;
        }
    }

    /**
     * Time Complexity: O(n)
     * Space complexity: O(1)
     * @param l1
     * @param l2
     * @return
     */
    private static Node findIntersectionNode(Node l1, Node l2) {

        int l1length = length(l1);
        int l2length = length(l2);


        if(l1length > l2length) {
            l1 = advanceListByK(l1length-l2length, l1);
        } else {
            l2 = advanceListByK(l2length-l1length, l2);
        }

        while (l1 != null && l2 != null && l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

    private static Node advanceListByK(int k, Node l) {
        while(k-- > 0) {
            l = l.next;
        }
        return l;
    }

    private static int length(Node l) {
        int length=0;
        while(l != null) {
            ++length;
            l = l.next;
        }
        return length;
    }

    private static Node findIntersectionNode(Node l1Head, Node l2Head, int l1Length, int l2Length) {

        int diff = Math.abs(l1Length-l2Length);
        Node l1CurNode = l1Head;
        Node l2CurNode = l2Head;

        if(l2Length > l1Length) {
            int index=1;
            while(l2CurNode != null && index <= diff) {
                ++index;
                l2CurNode = l2CurNode.next;
            }
        } else {

            int index=1;
            while(l1CurNode != null && index <= diff) {
                ++index;
                l1CurNode = l1CurNode.next;
            }
        }

        while(l1CurNode != null && l2CurNode != null) {
            if(l1CurNode == l2CurNode) {
                return l1CurNode;
            }
            l1CurNode = l1CurNode.next;
            l2CurNode = l2CurNode.next;
        }

        return null;
    }

    /**
     * 1->2->3->4->5->6->7->null
     *             ^
     *       8->9 -|
     */
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insert(new Node(1));
        l1.insert(new Node(2));
        l1.insert(new Node(3));
        l1.insert(new Node(4));
        Node intersectionNode = new Node(5);
        l1.insert(intersectionNode);
        l1.insert(new Node(6));
        l1.insert(new Node(7));

        LinkedList l2 = new LinkedList();
        l2.insert(new Node(8));
        l2.insert(new Node(9));
        l2.insert(intersectionNode);

        Node intersectionNodeResult = findIntersectionNode(l1.head, l2.head, 7, 5);

        Node intersectionNodeResult2 = findIntersectionNode(l1.head, l2.head);
        System.out.println("all done");

    }


}
