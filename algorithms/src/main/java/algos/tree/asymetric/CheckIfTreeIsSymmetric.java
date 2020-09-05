package algos.tree.asymetric;

/**
 *       7
 *     8   8
 *   9  0 0  9
 */

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

public class CheckIfTreeIsSymmetric {

    private static boolean checkIfTreeIsSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkIfTreeIsSymmetric(root.left, root.right);
    }

    private static boolean checkIfTreeIsSymmetric(TreeNode subtree0, TreeNode subtree1) {
        if(subtree0 == null && subtree1 == null) {
            return true;
        } else if(subtree0 != null && subtree1 != null) {
            return subtree0.data == subtree1.data && checkIfTreeIsSymmetric(subtree0.left, subtree1.right) &&
                checkIfTreeIsSymmetric(subtree0.right, subtree1.left);
        } else {
            return false;
        }
    }



    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(7);
        binaryTree.root.left = new TreeNode(8);
        binaryTree.root.right = new TreeNode(8);
        binaryTree.root.left.left = new TreeNode(9);
        binaryTree.root.right.right = new TreeNode(9);

        System.out.println(checkIfTreeIsSymmetric(binaryTree.root));
    }

}
