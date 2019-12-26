package algos.linkedlist.cycle;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 1    2   3   4   5
 *          |        |
*               -
 *
*  This list has a cycle. Note: we are not talking about value. We are talking about node pointers
 *
 *  Second type of question could be 1->2->3->2->5->null.. So here 3 node points to a different node of 2. This is not cycle we are referrring here
 */

public class LinkedListHasCycle {

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

        public void insert(Node newNode) {

            if (header == null) {
                header = newNode;
            } else {
                Node currentNode = header;

                while(currentNode.next != null) {
                    currentNode = currentNode.next;
                }

                currentNode.setNext(newNode);
            }
        }

        @Override
        public String toString() {

            for(Node currentNode = header; currentNode != null; currentNode = currentNode.next) {
                System.out.println(currentNode.data);
            }

            return "";
        }
    }

    private static boolean hasCycleUsingSet(Node node) {

        Set<Node> visited = new HashSet<>();

        for(Node currentNode = node; currentNode != null; currentNode = currentNode.next) {
            if (visited.contains(currentNode)) {
                return true;
            }

            visited.add(currentNode);
        }

        return false;

    }


    private static boolean hasCycleUsingRunner(Node node) {
        if (node == null) {
            return false;
        }

        Node runner = node.next;

        while (runner != null) {

            runner = runner.next;

            if (runner == null) {
                break;
            }

            runner = runner.next; // runner incremented twice
            node = node.next; // node incremented once

            if (runner == node) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node node = new Node(3);
        linkedList.insert(new Node(1));
        linkedList.insert(new Node(2));
        linkedList.insert(node);
        linkedList.insert(new Node(4));
        linkedList.insert(new Node(5));
        //linkedList.insert(node);

        //System.out.println(linkedList);

        //System.out.println(hasCycleUsingSet(linkedList.header));

        System.out.println(hasCycleUsingRunner(linkedList.header));

    }

}
