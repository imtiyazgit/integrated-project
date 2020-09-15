package algos.tree.rangesumbst;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

public class RangeSumBST {

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int sum =0;
        while(!queue.isEmpty()) {

            TreeNode current = queue.remove();

            if(current.data >= L && current.data <= R) {
                sum += current.data;
            }
            if(current.left != null && current.data > L) {
                queue.add(current.left);
            }
            if(current.right != null && current.data < R) {
                queue.add(current.right);
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left =new TreeNode(5);
        root.left.left =new TreeNode(3);
        root.left.right =new TreeNode(7);

        root.right =new TreeNode(15);
        root.right.right =new TreeNode(18);

        System.out.println(rangeSumBST(root, 7, 15));
    }
}
