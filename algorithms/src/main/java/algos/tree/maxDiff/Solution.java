package algos.tree.maxDiff;

class TreeNode{
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

class Result {
    int max;
}

public class Solution {
    public static int maxAncestorDiff(TreeNode root) {
        Result result = new Result();
        maxAncestorDiffHelper(root, result);
        return result.max;
    }

    public static int maxAncestorDiffHelper(TreeNode root, Result result) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null) {
            return root.data;
        }


        int leftValue = maxAncestorDiff(root.left);
        int rightValue = maxAncestorDiff(root.right);
        int minFromSubtree = Math.min(leftValue, rightValue);
        result.max = Math.max(result.max, root.data - minFromSubtree);
        return Math.min(minFromSubtree, root.data);
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        // Making above given diagram's binary tree
        tree.root = new TreeNode(8);
        tree.root.left = new TreeNode(3);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(6);
        tree.root.left.right.left = new TreeNode(4);
        tree.root.left.right.right = new TreeNode(7);

        tree.root.right = new TreeNode(10);
        tree.root.right.right = new TreeNode(14);
        tree.root.right.right.left = new TreeNode(13);

        System.out.println("Maximum difference between a node and"
                + " its ancestor is : " + maxAncestorDiff(tree.root));
    }
}
