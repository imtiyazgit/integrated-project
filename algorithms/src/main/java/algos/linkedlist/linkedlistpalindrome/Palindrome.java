package algos.linkedlist.linkedlistpalindrome;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList {

    int length;
    Node header;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (header == null) {
            header = newNode;
        } else {
            Node currentNode = header;

            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }

        length++;
    }

    @Override
    public String toString() {
        Node currentNode = header;
        while(currentNode != null) {
            System.out.print(currentNode.data +" ");
            currentNode = currentNode.next;
        }
        return "";
    }
}

public class Palindrome {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(1);

        System.out.println(linkedList);
    }
}
