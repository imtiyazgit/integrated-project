package algos.tree.findanode;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class BST {

    public Node insertUsingRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else if (data < root.data) {
            root.left = insertUsingRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertUsingRecursive(root.right, data);
        }

        return root;
    }

    public Node findUsingRecursive(Node root, int data) {
        if(root == null) {
            return null;
        } else if(data < root.data) {
            return findUsingRecursive(root.left, data);
        } else if(data > root.data) {
            return findUsingRecursive(root.right,data);
        }

        return root;
    }
}



public class BSTFindaNode {

    public static void main(String[] args) {
        BST bst = new BST();
        Node root = bst.insertUsingRecursive(null, 7);
        root = bst.insertUsingRecursive(root, 4);
        root = bst.insertUsingRecursive(root, 2);
        root = bst.insertUsingRecursive(root, 6);
        root = bst.insertUsingRecursive(root, 9);

        System.out.println(root);

        Node node = bst.findUsingRecursive(root, 4);
        System.out.println(node); // should have right 6 and left 2

        node = bst.findUsingRecursive(root, 67);
        System.out.println(node); // should be null


    }
}
