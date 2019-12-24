package algos.linkedlist.reverse;

public class LinkedListReverse {
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

                currentNode.setNext(newNode);

            }
        }

        public void printReverse(Node node) {
            if(node == null) {
                return;
            }

            printReverse(node.next);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);

        linkedList.printReverse(linkedList.header);

    }
}
