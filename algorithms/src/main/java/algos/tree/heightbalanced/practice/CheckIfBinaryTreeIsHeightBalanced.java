package algos.tree.heightbalanced.practice;

/**
 *
 *      7
 *    8   9
 *  10

 *
 * Approach1: At each node, calculate the height to the left and to the right and check if the node is height balanced and top down approach -- O(n2)
 *
 * Approach2: O(n) as the time complexity
 *
 *
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

class HeightBalancedInfo {
    boolean isBalanced;
    int height;

    public HeightBalancedInfo(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}

public class CheckIfBinaryTreeIsHeightBalanced {

    private static HeightBalancedInfo checkIfTreeIsHeightBalanced(TreeNode root) {
        if(root == null) {
            return new HeightBalancedInfo(true, -1);
        }

        HeightBalancedInfo leftHeightBalance = checkIfTreeIsHeightBalanced(root.left);
        if(!leftHeightBalance.isBalanced) {
            return leftHeightBalance;
        }

        HeightBalancedInfo rightHeightBalance = checkIfTreeIsHeightBalanced(root.right);
        if(!rightHeightBalance.isBalanced) {
            return rightHeightBalance;
        }

        boolean isNodeHeightBalanced = Math.abs(leftHeightBalance.height - rightHeightBalance.height) <= 1;
        int height = Math.max(leftHeightBalance.height, rightHeightBalance.height) + 1;

        return new HeightBalancedInfo(isNodeHeightBalanced, height);
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(7);
        binaryTree.root.left = new TreeNode(8);
        binaryTree.root.right = new TreeNode(9);
        binaryTree.root.left.left= new TreeNode(10);
        binaryTree.root.left.left.left= new TreeNode(11);

        System.out.println(checkIfTreeIsHeightBalanced(binaryTree.root).isBalanced);

    }
}
