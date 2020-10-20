package algos.tree.verticalorder.baseverticalordertraversal;

import java.util.*;

public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class NodeInfo {
        TreeNode root;
        int hd;

        public NodeInfo(TreeNode root, int hd) {
            this.root = root;
            this.hd = hd;
        }
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(new NodeInfo(root, 0));

        int minHd = Integer.MAX_VALUE;
        int maxHd = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();

        while (!q.isEmpty()) {
            NodeInfo nodeInfo = q.poll();
            map.putIfAbsent(nodeInfo.hd, new ArrayList());
            map.get(nodeInfo.hd).add(nodeInfo.root.val);

            minHd = Math.min(minHd, nodeInfo.hd);
            maxHd = Math.max(maxHd, nodeInfo.hd);

            if (nodeInfo.root.left != null) {
                q.offer(new NodeInfo(nodeInfo.root.left, nodeInfo.hd - 1));
            }

            if (nodeInfo.root.right != null) {
                q.offer(new NodeInfo(nodeInfo.root.right, nodeInfo.hd + 1));
            }

        }

        for (int i = minHd; i <= maxHd; i++) {
            res.add(map.get(i));
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> results = verticalOrder(root);

        System.out.println(results);
    }
}
