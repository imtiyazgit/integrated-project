package algos.tree.traversal.recursive;


class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

class BinaryTree {
    TreeNode root;
}

public class PostOrderRecursive {

    private static void postOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.println(root.data);
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(10);
        binaryTree.root.left = new TreeNode(-6);
        binaryTree.root.right = new TreeNode(15);
        binaryTree.root.left.right = new TreeNode(8);

        postOrderRecursive(binaryTree.root);
    }
}
