package algos.tree.pathsumii;

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

public class PathSumII {

    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList();
        findPaths(root, sum, new ArrayList<Integer>(), paths);

        return paths;
    }

    /**
     *          5
     *      4       8
     *   11      13   4
     * 7   2         5  1
     *
     */
    private static void findPaths(TreeNode root, int sum, ArrayList<Integer> current, List<List<Integer>> paths) {
        if(root == null) {
            return;
        }
        current.add(root.data);

        if(root.data ==sum && root.left == null && root.right == null) {
            paths.add(current);
            return;
        }

        findPaths(root.left, sum-root.data, new ArrayList<Integer>(current), paths);
        findPaths(root.right, sum-root.data, new ArrayList<Integer>(current), paths);

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(5);
        binaryTree.root.left = new TreeNode(4);
        binaryTree.root.right = new TreeNode(8);

        binaryTree.root.left.left= new TreeNode(11);
        binaryTree.root.right.left = new TreeNode(13);
        binaryTree.root.right.right = new TreeNode(4);

        binaryTree.root.left.left.left= new TreeNode(7);
        binaryTree.root.left.left.right = new TreeNode(2);

        binaryTree.root.right.right.left = new TreeNode(5);
        binaryTree.root.right.right.right = new TreeNode(1);

        System.out.println(binaryTree);

        System.out.println(pathSum(binaryTree.root, 22));

    }
}
