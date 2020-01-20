package algos.tree.traversal;

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

    public Node insertUsingRecursion(Node root, int data) {
        if (root == null) {
            Node newNode = new Node(data);
            return newNode;
        } else if(data < root.data) {
            root.left = insertUsingRecursion(root.left, data);
        } else if (data > root.data) {
            root.right = insertUsingRecursion(root.right, data);
        }

        return root;

    }

    // PreOrder - DLR
    public void preorderTraversal(Node root) {

        if (root != null) {
            // Visit the node
            System.out.println(root.data);

            // Go left
            preorderTraversal(root.left);

            // Go right
            preorderTraversal(root.right);
        }

    }


    // InOrder - LDR
    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.data);

            inOrderTraversal(root.right);

        }
    }

    // postOrder - LRD
    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.data);
        }
    }
}

public class TreeTraversals {

    public static void main(String[] args) {

        /**
         *     7
         *  4    9
         * 3 5  8
         * 2
         */
        BST bst = new BST();
        Node root = bst.insertUsingRecursion(null, 7);
        root = bst.insertUsingRecursion(root, 4);
        root = bst.insertUsingRecursion(root, 3);
        root = bst.insertUsingRecursion(root, 5);
        root = bst.insertUsingRecursion(root, 2);
        root = bst.insertUsingRecursion(root, 9);
        root = bst.insertUsingRecursion(root, 8);

        System.out.println(root);


        bst.preorderTraversal(root);

        System.out.println("-------------------------------------------------------");

        bst.inOrderTraversal(root);

        System.out.println("-------------------------------------------------------");

        bst.postOrderTraversal(root);

    }
}
