package algos.tree.traversal.iterative;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreOrderIterative {

    /**
     *       10
     *  -6      15
     *     8
     *
     * 10 -6 8 15
     */
    private static void preOrderIterative(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);

        while(!stack.isEmpty()) {
            root = stack.removeFirst();
            System.out.println(root.data);

            if(root.right != null) {
                stack.push(root.right);
            }

            if(root.left != null) {
                stack.push(root.left);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(10);
        binaryTree.root.left = new TreeNode(-6);
        binaryTree.root.right = new TreeNode(15);
        binaryTree.root.left.right = new TreeNode(8);

        preOrderIterative(binaryTree.root);
    }
}
