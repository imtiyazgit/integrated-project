package algos.tree.pathsum;

import java.util.ArrayList;
import java.util.List;

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

public class PathSum {
    /**
     *  *      7
     *  *    8   9
     *  *  10  1
     */
    // sum 16
    private static boolean pathSum(TreeNode root, int sum, List results) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            if(root.data == sum) {
                results.add(root.data);
                return true;
            } else {
                return false;
            }
        }

        if(pathSum(root.left, sum-root.data, results)) {
            results.add(root.data);
            return true;
        }

        if(pathSum(root.right, sum-root.data, results)) {
            results.add(root.data);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(7);
        binaryTree.root.left = new TreeNode(8);
        binaryTree.root.right = new TreeNode(9);
        binaryTree.root.left.left= new TreeNode(10);
        binaryTree.root.left.right = new TreeNode(1);

        ArrayList results = new ArrayList<>();

        System.out.println(pathSum(binaryTree.root, 16, results));
        System.out.println(results);

    }


}
