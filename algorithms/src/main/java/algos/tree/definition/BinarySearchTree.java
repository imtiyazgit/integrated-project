package algos.tree.definition;

class Node {
    int data;
    Node right;
    Node left;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}

public class BinarySearchTree {

    public Node insertUsingRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else if (data < root.data) {
            // You need to assign here, because you got the new node.
            root.left = insertUsingRecursive(root.left, data);
        } else if(data > root.data) {
            // You need to assign here, because you got the new node.
            root.right = insertUsingRecursive(root.right, data);
        }

        return root;
    }

    public Node findNodeUsingRecursive(Node current, int data) {
        if(current == null) {
            // You reached to leaf nodes, without finding element
            return null;
        }
        if(data < current.data) {
            // Once found, directly return. Do not assign
            return findNodeUsingRecursive(current.left, data);
        } else if(data > current.data) {
            // Once found, directly return. Do not assign
            return findNodeUsingRecursive(current.right, data);
        } else {
            return current;
        }
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.left);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node root = binarySearchTree.insertUsingRecursive(null, 7);
        root = binarySearchTree.insertUsingRecursive(root, 4);
        root = binarySearchTree.insertUsingRecursive(root, 6);
        root = binarySearchTree.insertUsingRecursive(root, 2);
        root = binarySearchTree.insertUsingRecursive(root, 8);

        Node node = binarySearchTree.findNodeUsingRecursive(root, 80);



        //binarySearchTree.inOrderTraverseTree(binarySearchTree);

        System.out.println("Done");

    }
}
