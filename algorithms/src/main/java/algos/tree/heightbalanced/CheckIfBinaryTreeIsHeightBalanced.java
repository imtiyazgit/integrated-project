package algos.tree.heightbalanced;

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

class BalanceHeight {
    boolean balanced;
    int height;

    public BalanceHeight(boolean balanced, int height) {
        this.balanced = balanced;
        this.height = height;
    }
}


public class CheckIfBinaryTreeIsHeightBalanced {

    private static BalanceHeight isHeightBalanced(TreeNode root) {
        if(root == null) {
            return new BalanceHeight(true, -1);
        }

        BalanceHeight leftBalanceHeight = isHeightBalanced(root.left);
        if(!leftBalanceHeight.balanced) {
            return leftBalanceHeight;
        }

        BalanceHeight rightBalanceHeight = isHeightBalanced(root.right);
        if(!rightBalanceHeight.balanced) {
            return rightBalanceHeight;
        }

        boolean nodeBalanced = Math.abs(leftBalanceHeight.height - rightBalanceHeight.height) <= 1 ;

        int nodeHeight = 1 + Math.max(leftBalanceHeight.height, rightBalanceHeight.height);

        return new BalanceHeight(nodeBalanced, nodeHeight);
    }

    /**
     *       7
     *     8    9
     *  10
     *
     *
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(7);
        binaryTree.root.left = new TreeNode(8);
        binaryTree.root.right = new TreeNode(9);

        binaryTree.root.left.left = new TreeNode(10);
        binaryTree.root.left.left.left = new TreeNode(20);

        System.out.println(isHeightBalanced(binaryTree.root).balanced);

    }
}
