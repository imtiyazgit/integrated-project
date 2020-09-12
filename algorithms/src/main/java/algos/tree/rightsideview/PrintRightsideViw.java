package algos.tree.rightsideview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class PrintRightsideViw {

    /**
     *      1
     *  2       3
     *    5        4
     *
     */
    public static List<Integer> printRight(TreeNode root) {
        List<Integer> visibleValues = new ArrayList<>();
        if(root == null) {
            return visibleValues;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if(i == size-1) {
                    visibleValues.add(current.data);
                }
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return visibleValues;

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(1);
        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(3);
        binaryTree.root.left.right = new TreeNode(5);
        binaryTree.root.right.right = new TreeNode(4);

        System.out.println(printRight(binaryTree.root));
    }

}
