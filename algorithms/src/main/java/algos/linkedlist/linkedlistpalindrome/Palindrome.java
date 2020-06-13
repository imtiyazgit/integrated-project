package algos.linkedlist.linkedlistpalindrome;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

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

class LinkedList {

    int length;
    ListNode header;

    public void insert(int data) {
        ListNode newListNode = new ListNode(data);

        if (header == null) {
            header = newListNode;
        } else {
            ListNode currentListNode = header;

            while(currentListNode.next != null) {
                currentListNode = currentListNode.next;
            }

            currentListNode.next = newListNode;
        }

        length++;
    }

    @Override
    public String toString() {
        ListNode currentListNode = header;
        while(currentListNode != null) {
            System.out.print(currentListNode.data +" ");
            currentListNode = currentListNode.next;
        }
        return "";
    }
}

public class Palindrome {

    // 5 ->4 -> 3 2 1
    public static ListNode reverse(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    // 1 2 3 4 5 4 3 2 1 - palindrome
    // 1 2 3 4 1 2 3 4 5 - Reverse second half and compare
    // 1 2 3 4 2 6 - not a palindrome
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode firstHalfIterator = head;

        while (fast != null && fast.next != null) {
            slow  = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfIterator = reverse(slow);

        while(secondHalfIterator != null && firstHalfIterator != null) {
            if (firstHalfIterator.data != secondHalfIterator.data) {
                return false;
            }
            firstHalfIterator = firstHalfIterator.next;
            secondHalfIterator = secondHalfIterator.next;
        }

        return true;

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(4);
        linkedList.insert(3);
        linkedList.insert(2);
        linkedList.insert(1);

        System.out.println(isPalindrome(linkedList.header));
    }
}
