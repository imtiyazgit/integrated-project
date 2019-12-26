package algos.linkedlist.splitintohalf;

public class SplitIntoHalf {

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

                while(currentNode.next != null) {
                    currentNode = currentNode.next;
                }

                currentNode.setNext(newNode);
            }

            length++;
        }

        @Override
        public String toString() {
            Node currentNode = header;
            while (currentNode != null) {
                System.out.print(currentNode.data +" ");
                currentNode = currentNode.next;
            }
            return "";
        }
    }


    private static Node divide(Node node) {
        // Generally node is the header here and we want to modify it directly. So no need to have currentNode
        if (node == null) {
            return null;
        }

        // Runner runs fast. Set thatf irst
        Node runner = node.next;

        while (runner != null) {
            runner = runner.next;

            // is runner null? If so, break. Otherwise set next one more time
            if (runner == null) {
                break;
            }

            runner = runner.next;
            // If runner itself which moves two steps is not null, then the follower should not be null. So, directly set next to it once
            node = node.next;
        }


        // By the time, loop completes, the node should be exactly at the middle 1->2->3->4-5. In this case it should be at 3 and we break link after it.

        Node nodeToReturn = node.next;

        // Now we need to modify the first list to break that link
        node.next = null;


        return nodeToReturn;
    }

    public static void main(String[] args) throws Throwable {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);

        System.out.println("original list: "+ linkedList);
        Thread.sleep(1000);

        Node node = divide(linkedList.header);

        System.out.println("original list after divide " + linkedList);

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

    }

}
