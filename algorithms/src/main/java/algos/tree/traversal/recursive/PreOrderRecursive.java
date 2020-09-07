package algos.tree.traversal.recursive;

public class PreOrderRecursive {

    /**
     *       10
     *  -6      15
     *     8
     *
     * 10 -6 8 15
     */
    private static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(10);
        binaryTree.root.left = new TreeNode(-6);
        binaryTree.root.right = new TreeNode(15);
        binaryTree.root.left.right = new TreeNode(8);

        preOrder(binaryTree.root);
    }

}
