package algos.tree.deleteanode;

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
        if (root == null) {
            root = new Node(data);
        } else if(data < root.data) {
            root.left = insertUsingRecursive(root.left, data);
        } else if(data > root.data) {
            root.right = insertUsingRecursive(root.right, data);
        }

        return root;
    }

    public Node findMaxUsingRecursive(Node root) {
        if (root == null) {
            return null;
        } else if(root.right == null) {
            return root;
        }

        return findMaxUsingRecursive(root.right);
    }


    public Node deleteUsingRecursive(Node root, int data) {
        Node maxNode ;
        if (root == null) {
            return null;
        } else if(data < root.data) {
            root.left = deleteUsingRecursive(root.left, data);
        } else if(data > root.data) {
            root.right = deleteUsingRecursive(root.right, data);
        } else {
            // current node matches with data and its leaf node without any child
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                // Only one child. Having right nodes. Instead of returning current node, return its right subtree
                return root.right;
            } else if (root.right == null) {
                // Only one child. Having left subtree. Instead of returning current node, return its left subtree
                return root.left;
            }  else {
                // Matching node has both childs
                // First find next max element in the left of the subtree
                maxNode = findMaxUsingRecursive(root.left);

                // Now replace current nodes data with next max element data
                root.data = maxNode.data;

                // Now delete the next max element we found. Typically, next max element is the right most elment of the left subtree which does not have any children
                root.left = deleteUsingRecursive(root.left, root.data);
            }

        }
        return root;
    }
}

public class DeleteANode {

    public static void main(String[] args) {
        // Usecase#1 delete leaf node
        BST bst = new BST();

        Node root = bst.insertUsingRecursive(null, 6);
        root = bst.insertUsingRecursive(root, 2);
        root = bst.insertUsingRecursive(root, 1);
        root = bst.insertUsingRecursive(root, 5);
        root = bst.insertUsingRecursive(root, 8);

        System.out.println(root);

        root = bst.deleteUsingRecursive(root, 5);
        System.out.println(root);

        // --------------------
        // Usecase#2 Delete a node having only one child
        BST bst2 = new BST();

        Node root2 = bst2.insertUsingRecursive(null, 6);
        root2 = bst2.insertUsingRecursive(root2, 2);
        root2 = bst2.insertUsingRecursive(root2, 1);
        root2 = bst2.insertUsingRecursive(root2, 4);
        root2 = bst2.insertUsingRecursive(root2, 3);
        root2 = bst2.insertUsingRecursive(root2, 8);

        root2 = bst2.deleteUsingRecursive(root2, 4);
        System.out.println(root2);


        // -----------------
        BST bst3 = new BST();

        Node root3 = bst3.insertUsingRecursive(null, 6);
        root3 = bst3.insertUsingRecursive(root3, 5);
        root3 = bst3.insertUsingRecursive(root3, 15);
        root3 = bst3.insertUsingRecursive(root3, 13);
        root3 = bst3.insertUsingRecursive(root3, 14);
        root3 = bst3.insertUsingRecursive(root3, 9);
        root3 = bst3.insertUsingRecursive(root3, 8);
        root3 = bst3.insertUsingRecursive(root3, 10);
        root3 = bst3.insertUsingRecursive(root3, 12);

        /**
         *        6
         *    5               15
         *                13
         *            9      14
         *         8    10
         *                12
         */
        System.out.println(root3);

        Node maxNode = bst3.findMaxUsingRecursive(root3);
        System.out.println(maxNode);

        root3 = bst3.deleteUsingRecursive(root3, 13);
        System.out.println(root3);



    }
}
