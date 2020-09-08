package algos.tree.traversal.iterative;

import java.util.ArrayDeque;
import java.util.Deque;

public class InOrderIterative {

    /**
     *         7
     *     5        9
     *   4  6     8 10
     *
     *   left visit right
     *
     *   4 5 6 7 8 9 10
     */
    private static void inOrderIterative(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(true) {

            if(root != null) {
                stack.addFirst(root);
                root = root.left;
            } else {
                // Root is null..This would happen either for left node or right node at the end of the tree
                if(stack.isEmpty()) {
                    break;
                }

                root = stack.removeFirst(); // If root is null, then we always get from stack
                System.out.println(root.data);
                root = root.right; // if root right is null, dont worry we will get from stack top
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(7);

        binaryTree.root.left = new TreeNode(5);
        binaryTree.root.right= new TreeNode(9);

        binaryTree.root.left.left = new TreeNode(4);
        binaryTree.root.left.right = new TreeNode(6);

        binaryTree.root.right.left= new TreeNode(8);
        binaryTree.root.right.right= new TreeNode(10);

        inOrderIterative(binaryTree.root);
    }
}
