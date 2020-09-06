package algos.tree.pathsum.practice;

import java.util.ArrayList;

/**
 *       5
 *     6    7
 *   1   2     3
 * 4   5      1   8
 *
 * given sum: 16
 * Return true if there is a path matching sum : paths: [[5,6,1,4], [5,7,3,1]]
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

public class PathSumBinaryTree {

    /**
     *  *      7
     *  *    8   9
     *  *  10  1
     *
     *  If sum is 16, it should return true
     */
    private static boolean hasPathMatchingGivenSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        if(root.data == sum && root.left == null && root.right == null) {
            return true;
        }

       /* boolean leftResult = hasPathMatchingGivenSum(root.left, sum - root.data);
        boolean rightResult = hasPathMatchingGivenSum(root.right, sum - root.data);

        return leftResult || rightResult;*/

        return hasPathMatchingGivenSum(root.left, sum - root.data) || hasPathMatchingGivenSum(root.right, sum - root.data);

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(7);
        binaryTree.root.left = new TreeNode(8);
        binaryTree.root.right = new TreeNode(9);
        binaryTree.root.left.left= new TreeNode(10);
        binaryTree.root.left.right = new TreeNode(1);


        System.out.println(hasPathMatchingGivenSum(binaryTree.root, 16));

    }


}
