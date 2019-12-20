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
}

class LinkedList {
    Node header;

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

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);

        System.out.println(linkedList);

    }
}
