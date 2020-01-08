package algos.linkedlist.yproblemmergenode;

public class YProblem {

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

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
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
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }

                currentNode.setNext(newNode);
            }

            length++;
        }

        @Override
        public String toString() {
            Node currentNode = header;
            while(currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }

            return "";
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        linkedList.insert(new Node(1));
        linkedList.insert(new Node(2));
        linkedList.insert(node3);
        linkedList.insert(node4);
        linkedList.insert(node5);

        System.out.println("First list" + linkedList);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insert(new Node(11));
        linkedList2.insert(new Node(12));
        linkedList2.insert(node3);


        System.out.println("Second list" + linkedList2);

    }
}
