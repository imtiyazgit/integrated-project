package algos.tree.pathsumii.practice;

import java.util.ArrayList;
import java.util.List;

/**
 *          5
 *      6       8
 *   5      13   4
 * 7   2         5  1
 *
 *
 *
 * given sum: 18
 * Return all paths: [[5,6,5,2], [5,8,4,1]]
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

public class FindAllPathsInABinaryTreeMatchingGivenSum {

    private static List<List<Integer>> findAllPathsMatchingGivenSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList();
        findAllPathsMatchingGivenSum(root, sum, new ArrayList<Integer>(), paths);
        return paths;
    }

    private static void findAllPathsMatchingGivenSum(TreeNode root, int sum, ArrayList<Integer> current, List<List<Integer>> paths) {
        if(root == null) {
            return;
        }
        current.add(root.data);
        if(root.left == null && root.right == null && sum == root.data) {
            paths.add(current);
        }

        findAllPathsMatchingGivenSum(root.left, sum-root.data, new ArrayList<>(current), paths);
        findAllPathsMatchingGivenSum(root.right, sum-root.data, new ArrayList<>(current), paths);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(5);
        binaryTree.root.left = new TreeNode(6);
        binaryTree.root.right = new TreeNode(8);

        binaryTree.root.left.left= new TreeNode(5);
        binaryTree.root.right.left = new TreeNode(13);
        binaryTree.root.right.right = new TreeNode(4);

        binaryTree.root.left.left.left= new TreeNode(7);
        binaryTree.root.left.left.right = new TreeNode(2);

        binaryTree.root.right.right.left = new TreeNode(5);
        binaryTree.root.right.right.right = new TreeNode(1);


        System.out.println(findAllPathsMatchingGivenSum(binaryTree.root, 18));

    }

}
