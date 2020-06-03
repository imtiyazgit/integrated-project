package algos.linkedlist.YProblemOrIntersectionOrOverlapping;

class Node {
    public int item;
    public Node next;

    public Node(int item) {
        this.item = item;
    }
}

class LinkedList {
    public Node head;

    public void insert(int x) {
        Node node = new Node(x);

        if (head == null) {
            head = node;
            return;
        }

        Node currentNode = head;
        // Go to last node
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }
}
public class YProblem {

    // node1 =linkedlist1-head, node2=lin,,''';kedlist2-head initially, overridden later, m size of l1, n size of l2
    // returns null, if there is no merge point
    static Node findMergeNode(Node node1, Node node2, int m, int n) {
        // traverse m-n nodes and then start comparing in one loop
        if (m>n) {
            for (int i=0;i<m-n;i++) {
                node1 = node1.next;
            }
        } else {
            for (int i=0;i<n-m;i++) {
                node2 = node2.next;
            }
        }

        while (node1.next != null && node2.next != null) {
            if (node1.item == node2.item) {
                return node1;
            }
            node1 =node1.next;
            node2 =node2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insert(10);
        l1.insert(20);
        l1.insert(30);
        l1.insert(40);
        l1.insert(50);

        LinkedList l2 = new LinkedList();
        l2.insert(15);
        l2.insert(30);
        l2.insert(41);
        l2.insert(51);

        Node mergeNode = findMergeNode(l1.head, l2.head, 5, 4);
        if (mergeNode == null) {
            System.out.println("No Merge node found");
        }
        System.out.println(mergeNode.item);
    }
}
