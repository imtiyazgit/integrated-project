package algos.linkedlist.deleteduplicates;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicatesFromLinkedList {

    static class Node {
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

                currentNode.next = newNode;
            }

            length++;
        }


        @Override
        public String toString() {

            for(Node currentNode = header; currentNode != null; currentNode = currentNode.next) {
                System.out.print(currentNode.data +" ");
            }

            return "";
        }
    }


    // 1 2 3 2 4
    private static void deleteDuplicatesUsingAdditionalSpace(Node node) {

        if (node == null) {
            throw new IllegalArgumentException("Linked list is empty!");
        }

        Set<Integer> set = new HashSet<>();

        Node prev = null;

        while (node != null) {
            if (set.contains(node.getData())) {
                prev.next = node.next;

            } else {
                // set does not have this element, so add it
                set.add(node.getData());
                prev = node;
            }

            node = node.next;
        }

    }

    // 1 2 2 3
    private static void deleteDuplicatesWithoutUsingSetButWithTwoLoops(Node node) {

        while (node != null) {
            Node curr = node;

            while (curr.next != null) {
                if (curr.next.getData() == node.getData()) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }

            node = node.next;
        }

    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(2);
        linkedList.insert(4);

        System.out.println(linkedList);

        //deleteDuplicatesUsingAdditionalSpace(linkedList.header);

        deleteDuplicatesWithoutUsingSetButWithTwoLoops(linkedList.header);

        System.out.println(linkedList);
    }
}
