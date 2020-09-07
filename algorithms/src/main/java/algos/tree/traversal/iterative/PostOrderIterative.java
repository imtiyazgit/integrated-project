package algos.tree.traversal.iterative;

import java.util.ArrayDeque;
import java.util.Deque;

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

public class PostOrderIterative {

    /**
     *       10
     *  -6      15
     *     8
     *
     */
    private static void postOrderIterative(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.addFirst(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;

                if(temp == null) {
                    // leaf node
                    temp = stack.removeFirst();
                    System.out.println(temp.data);

                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.removeFirst();
                        System.out.println(temp.data);
                    }
                } else {
                    current = temp;
                }
            }
        }


    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(10);
        binaryTree.root.left = new TreeNode(-6);
        binaryTree.root.right = new TreeNode(15);
        binaryTree.root.left.right = new TreeNode(8);

        postOrderIterative(binaryTree.root);
    }
}
