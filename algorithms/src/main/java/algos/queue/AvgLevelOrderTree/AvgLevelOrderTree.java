package algos.queue.AvgLevelOrderTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 *                       314  --> 314.0
 *                  6            6  --> 6.0
 *             271     561    2       271 --> 276.25
 *         28    0      3     1        28
 *                    17    401  257
 *                           641
 *                           */
public class AvgLevelOrderTree {
    public static List<Double> avgLevelOrderTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> avgResults = new ArrayList<>();

        queue.offer(root);

        double avgAtLevel = 0;
        while (!queue.isEmpty()) {
            avgAtLevel = 0;

            int noOfNodesAtLevel = queue.size();
            for (int i = 0; i < noOfNodesAtLevel; i++) {
                TreeNode node = queue.poll();
                avgAtLevel+= node.data;

                // populate its child
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            avgAtLevel = avgAtLevel/noOfNodesAtLevel;
            avgResults.add(avgAtLevel);
        }

        return avgResults;
    }

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        List<Double> results = avgLevelOrderTree(root);
        System.out.println(results);
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
