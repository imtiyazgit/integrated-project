package algos.queue.LevelOrderInReverse.PT;

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

// op: 641, 17, 401, 257 28,0, 3 1 28 271 561 2 271 6 6  314
    // Queue Stack
    // 314
    // 6  6    314
    // 271, 2   6
    // 271 561  6
public class PrintTreeInReverOrder {

    public static void printTreeInReverseOrder(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            // First pop the node
            TreeNode node = queue.poll();

            // Populate childs of this node into the queue
            if(node.right != null) {
                queue.offer(node.right);
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            stack.offerFirst(node);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.removeFirst().data + " ");
        }
    }


    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        printTreeInReverseOrder(root);
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
