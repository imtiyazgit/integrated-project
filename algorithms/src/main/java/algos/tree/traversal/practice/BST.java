package algos.tree.traversal.practice;

public class BST {

    public TreeNode insertUsingRecursion(TreeNode root, int data) {
        if(root == null) {
            // when you do root.right or root.left, you will reach leaf null
            TreeNode newNode = new TreeNode(data);
            return newNode;
        }
        if(root.data < data) {
            root.right = insertUsingRecursion(root.right, data);
        } else if(root.data > data) {
            root.left = insertUsingRecursion(root.left, data);
        }

        return root;
    }
}
