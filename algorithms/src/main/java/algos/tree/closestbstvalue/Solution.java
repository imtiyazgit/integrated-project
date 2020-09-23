package algos.tree.closestbstvalue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.val = data;
    }
}

public class Solution {
    public static int closestValue(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            double test1= val - target;
            double test2 = closest - target;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root =  target < root.val ? root.left : root.right;
        }
        return closest;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);

        System.out.println(closestValue(root, 2.4));

    }
}
