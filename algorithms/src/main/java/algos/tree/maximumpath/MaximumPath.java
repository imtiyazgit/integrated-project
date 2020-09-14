package algos.tree.maximumpath;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class MaximumPath {

    private static int pathSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return pathSum;
    }

    public static int maxPathSumHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);

        pathSum = Math.max(pathSum, left+right+root.val);

        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);

        System.out.println(maxPathSumHelper(root));
    }
}
