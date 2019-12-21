package algos.linkedlist.nthtolast;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value + "";
    }
}

class LinkedList {
    Node header;
    int length;

    public void insert(int value) {
        if (header == null) {
            header = new Node(value);
        } else {

            Node currentNode = header;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.setNext(new Node(value));
        }

        length++;

    }

    public int size() {
        return length;
    }


    @Override
    public String toString() {
        String result = "";
        Node currentNode = header;
        while(currentNode != null) {
            result += currentNode.getValue() + " ";
            currentNode = currentNode.next;
        }
        return result;
    }
}

public class NthToLastLinkedList {

    // If you know the length of the linked list, then you can go directly to the node using length - n
    // You have iterate the list two times. Time Complexity O(2n) = O (n)
    private static int naiveApproach(LinkedList linkedList, int n) {

        int length = linkedList.length;

        if (n >= length) {
            return -1;
        }

        Node currentNode = linkedList.header;
        for (int i = 1; i < length - n; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.value;

    }


    // One iteration, Time Complexiy O(n)
    // Set both currentNode and followerNode to header
    // Iterate n times only the current node
    // Then, remaining iterations take both follower node and current node to next until you reach end i.e. current node null
    private static int nthToLast(LinkedList linkedlist, int n) {

        Node currentNode = linkedlist.header;
        Node followerNode = linkedlist.header;

        // Set current node after n iterations
        for (int i = 0; i < n ; i++) {
            if(currentNode.next == null) {
                return -1;
            }
            currentNode = currentNode.next;
        }

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            followerNode = followerNode.next;
        }
        return followerNode.value;


    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);

        System.out.println(linkedList);

        //System.out.println(linkedList.size());

        System.out.println(naiveApproach(linkedList, 5));

        //System.out.println(naiveApproach(linkedList, 6));



    }
}
