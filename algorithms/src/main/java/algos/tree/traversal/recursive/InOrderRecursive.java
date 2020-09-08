package algos.tree.traversal.recursive;

public class InOrderRecursive {

    /**
     *         7
     *     5        9
     *   4  6     8 10
     *
     *   left visit right
     *
     *   4 5 6 7 8 9 10
     */
    private static void inOrderRecursive(TreeNode root) {
        if(root == null) {
            return;
        }

        // left visit right
        inOrderRecursive(root.left);
        System.out.println(root.data);
        inOrderRecursive(root.right);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(7);

        binaryTree.root.left = new TreeNode(5);
        binaryTree.root.right= new TreeNode(9);

        binaryTree.root.left.left = new TreeNode(4);
        binaryTree.root.left.right = new TreeNode(6);

        binaryTree.root.right.left= new TreeNode(8);
        binaryTree.root.right.right= new TreeNode(10);

        inOrderRecursive(binaryTree.root);
    }
}
