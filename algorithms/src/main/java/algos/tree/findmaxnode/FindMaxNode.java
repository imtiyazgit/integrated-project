package algos.tree.findmaxnode;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
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
        if(root == null) {
            Node newNode = new Node(data);
            return newNode;
        }

        if(data < root.data) {
            root.left = insertUsingRecursive(root.left, data);
        } else if(data > root.data) {
            root.right = insertUsingRecursive(root.right, data);
        }

        return root;
    }

    /**
     * TimeComplexity: O(n) in the worst case if its a skew tree
     * SpaceComplexity: O(n) for recursive stack
     */
    public Node findMaxNodeUsingRecursive(Node root) {
        if (root.right == null) {
            return root;
        }

        return findMaxNodeUsingRecursive(root.right);
    }

    /**
     * TimeComplexity: O(n) in the worst case if its a skew tree
     * SpaceComplexity: O(1)
     */
    public Node findMaxNodeUsingIterative(Node root) {
        if (root == null) {
            return null;
        }

        while(root.right != null) {
            root = root.right;
        }

        return root;
    }
}

public class FindMaxNode {

    public static void main(String[] args) {
        BST bst = new BST();
        Node root = bst.insertUsingRecursive(null, 7);
        root = bst.insertUsingRecursive(root, 4);
        root = bst.insertUsingRecursive(root, 3);
        root = bst.insertUsingRecursive(root, 5);
        root = bst.insertUsingRecursive(root, 8);
        root = bst.insertUsingRecursive(root, 10);
        root = bst.insertUsingRecursive(root, 9);

        System.out.println(root);

        Node node = bst.findMaxNodeUsingRecursive(root);
        System.out.println(node);

        node = bst.findMaxNodeUsingIterative(root);
        System.out.println(node);

    }
}
