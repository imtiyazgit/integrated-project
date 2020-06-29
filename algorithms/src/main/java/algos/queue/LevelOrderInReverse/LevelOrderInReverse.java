package algos.queue.LevelOrderInReverse;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *                       314
 *                  6            6
 *             271     561    2       271
 *         28    0      3     1        28
 *                    17    401  257
 *                           641
 *                           */
public class LevelOrderInReverse {

    public static void printLevelOrderInReverse(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            //First take the node and populate its childs
            TreeNode node = queue.poll();

            // populate its right and left to the queue before and then push this node to stack
            if(node.right != null) {
                queue.offer(node.right);
            }

            if(node.left != null) {
                queue.offer(node.left);
            }

            // now that we populate nodes childs.. push this node whose process is complete to stack
            stack.addFirst(node);
        }

        // Just print all elements and it should be in reverse order
        while(!stack.isEmpty()) {
            System.out.println(stack.pollFirst().data);
        }

    }

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        printLevelOrderInReverse(root);
    }


    public static TreeNode createBinaryTree() {
        TreeNode A = new TreeNode(314);
        TreeNode B = new TreeNode(6);
        TreeNode C = new TreeNode(271);
        TreeNode D = new TreeNode(28);
        TreeNode E = new TreeNode(0);
        TreeNode F = new TreeNode(561);
        TreeNode G = new TreeNode(3);
        TreeNode H = new TreeNode(17);
        TreeNode I = new TreeNode(6);
        TreeNode J = new TreeNode(2);
        TreeNode K = new TreeNode(1);
        TreeNode L = new TreeNode(401);
        TreeNode M = new TreeNode(641);
        TreeNode N = new TreeNode(257);
        TreeNode O = new TreeNode(271);
        TreeNode P = new TreeNode(28);

        A.left = B;
        A.right= I;

        B.left = C;
        B.right = F;

        C.left = D;
        C.right = E;

        F.right = G;
        G.left = H;

        I.left = J;
        I.right = O;

        J.right = K;

        K.left = L;
        K.right = N;

        L.right = M;

        O.right = P;

        return A;
    }

}
