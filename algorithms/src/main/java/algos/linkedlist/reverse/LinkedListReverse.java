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

        // 1->2->3->4->5->null
        // 1-> null (prev)
        // Set head (current pointer)'s next element to the previous element. thats the logic
        public Node reverse(Node head) {
            Node prev = null;

            while(head != null) {
                // Since head's next variable is used to move forward and also we are updating it, store it in local variable
                Node next = head.next;

                // Set next element to the previous element. Set 1's next to prev null
                head.next = prev;

                // Once next element is pointed to prev, set prev to the current head
                prev = head;

                // Move head to the next element using the local variable. do not use head.next since its already pointed backwards
                head = next;
            }

            // ALWAYS RETURN PREV.. HEAD IS NULL
            return prev;

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

        Node head = linkedList.reverse(linkedList.header);
        System.out.println("all done");

    }
}
