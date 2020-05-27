package algos.linkedlist.reverse.sublistreverse;

import algos.linkedlist.reverse.LinkedListReversePT;

public class LinkedListSublistReverse {
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

    static class LinkedList {
        Node header;
        int length;

        public void insert(int data) {
            Node newNode = new Node(data);

            if (header == null) {
                header = newNode;
            } else {
                Node currentNode = header;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }

                currentNode.setNext(newNode);

            }
        }

        // 1->2->3>4->5->null
        // 1->4->3>2->5 -> null
        // start is 2 and end is 4
        public Node reverseSublist(Node head, int m, int n) {

            Node prev = null;
            Node currentNode = head;

            while(m>1) {
                prev = currentNode;
                currentNode = currentNode.next;
                m--;
                n--;
            }

            Node connectionNode = prev;
            Node tailNodeOfSublist = currentNode;

            while(n>0) {
                Node next = currentNode.next;
                currentNode.next=prev;
                prev = currentNode;
                currentNode = next;
                n--;
            }

            connectionNode.setNext(prev);
            tailNodeOfSublist.next = currentNode;

            return head;
        }

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);

        Node result = linkedList.reverseSublist(linkedList.header, 2, 4);

        System.out.println("all done"); // 1->4->3>2>5->null

    }
}
