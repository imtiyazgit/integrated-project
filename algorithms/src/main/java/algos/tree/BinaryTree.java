package algos.tree;

class Node {
    int key;
    String name;
    Node rightChild;
    Node leftChild;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}

public class BinaryTree {
    Node rootNode;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            Node focusNode = rootNode;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(50, "Boss");
        binaryTree.addNode(40, "Manager");
        binaryTree.addNode(45, "IT Manager");
        binaryTree.addNode(30, "Developer");
        binaryTree.addNode(35, "Supervisor");

        binaryTree.inOrderTraverseTree(binaryTree.rootNode);

    }
}
