package algos.linkedlist.basics.ex1;

public class LinkedList {

    private ListNode head;
    private int length;


    // insert node at beginning of the linked list
    public synchronized void insertAtBegin(ListNode node) {
        node.next = head;
        head = node;
        length++;
    }

    // insert node at end of the linked list
    public synchronized void insertAtEnd(ListNode node) {
        if(head == null) {
            head = node;
        } else {

            // Go to the last node
            ListNode currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.setNext(node);
        }

        length++;

    }

    public synchronized void insertAtPosition(ListNode node, int position) {

        // First fix position at either side. That means what if given position is negative or more than the length
        if(position<0) {
            position = 0;
        }

        if(position > length) {
            position = length;
        }

        // ------

        if(head==null) {
            head = node;
        } else if (position==0) {
            node.setNext(head);
            head = node;
        } else {

            // Find position node. Position node after which new node has to be inserted
            ListNode temp = head;
            for (int i=0; i<position; i++) {
                temp = temp.getNext();
            }

            node.next = temp.next;
            temp.setNext(node);
        }

        length++;
    }

    public void add(int data) {
        ListNode listNode = new ListNode();
        listNode.setData(data);
        if(head == null) {
            head = listNode;
        } else {
            ListNode currentNode = head;
            while (currentNode != null) {
                currentNode = head.next;
            }

        }
    }


    public int size() {
        int size =0;
        ListNode currentNode;

        while (head != null) {
            currentNode = head.next;
            size++;
        }

        return size;
    }

    @Override
    public String toString() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
        return "";
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(100);
        linkedList.add(102);
        linkedList.add(103);

        System.out.println(linkedList);

    }




    public static class ListNode {
        private int data;
        private ListNode next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
