package algos.linkedlist.cycle;

public class SearchElem {

    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    static class LinkedList {
        ListNode header;

        public ListNode insert(ListNode newNode) {
            if (header == null) {
                header = newNode;
            } else {
                ListNode currentNode = header;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = newNode;
            }

            return header;
        }

        public ListNode search(ListNode searchNode) {
            if (header == null) {
                return null;
            } else {
                ListNode currentNode = header;
                while(currentNode != null && currentNode.data != searchNode.data) {
                    currentNode = currentNode.next;
                }

                // Returns either null if search node is not found or returns the node itself
                return currentNode;
            }
        }

        public void deleteNode(ListNode node) {
            if(header == null) {
                throw new IllegalStateException("List is empty and node can not be deleted");
            } else {
                ListNode currentNode = header;
                while(currentNode!= null && currentNode.next != null) {
                    if(currentNode.next.data == node.data) {
                        currentNode.next = currentNode.next.next;
                    } else {
                        currentNode = currentNode.next;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(new ListNode(1));
        linkedList.insert(new ListNode(2));
        linkedList.insert(new ListNode(3));
        linkedList.insert(new ListNode(4));

        System.out.println(linkedList);

        ListNode nodeFromList = linkedList.search(new ListNode(9));
        System.out.println(nodeFromList);

        linkedList.deleteNode(new ListNode(3));
        System.out.println(linkedList);

    }

}
