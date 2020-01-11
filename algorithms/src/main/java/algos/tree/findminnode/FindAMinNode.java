package algos.tree.findminnode;

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
            root = new Node(data);
            return root;
        } else if(data < root.data) {
            root.left = insertUsingRecursive(root.left, data);
        } else if(data > root.data) {
            root.right = insertUsingRecursive(root.right, data);
        }

        return root;
    }

    /**
     *
     * TimeComplexity: O(n) if the BST is a skew tree
     * SpaceComplexity: O(n) for the recursive stack
     */
    public Node findMinNodeUsingRecursive(Node root) {
        if (root == null) {
            // Condition applicable only when client calls this. Root will never be null from recursive function stacks,
            // as we check below root.left
            return null;
        }
        if (root.left == null) {
            return root;
        }

        return findMinNodeUsingRecursive(root.left);
    }

    /**
     *
     * TimeComplexity: O(n) if the BST is a skew tree
     * SpaceComplexity: O(1)
     */
    public Node findMinNodeUsingIterative(Node root) {
        if (root == null) {
            return null;
        }

        Node current = root;
        while(current.left != null) {
            current = current.left;
        }

        return current;

    }
}

public class FindAMinNode {

    public static void main(String[] args) {
        BST bst = new BST();
        Node root = bst.insertUsingRecursive(null, 7);
        root = bst.insertUsingRecursive(root, 4);
        root = bst.insertUsingRecursive(root, 2);
        root = bst.insertUsingRecursive(root, 6);
        root = bst.insertUsingRecursive(root, 9);

        System.out.println(root);


        Node node = bst.findMinNodeUsingIterative(root);
        System.out.println(node); // prints 2

        node = bst.findMinNodeUsingRecursive(root);
        System.out.println(node); // prints 2
    }
}
