package algos.tree.diameter;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}
public class FindDiameterOfABinaryTree {

    static int longest =1;

    public static int findDiameterOfBT(TreeNode root) {
        findDiameter(root);
        return longest-1;
    }

    public static int findDiameter(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int leftHeight = findDiameter(root.left);
        int rightHeight = findDiameter(root.right);

        longest = Math.max(longest, leftHeight+rightHeight+1);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(6);
        root.right.left.right.right = new TreeNode(10);

        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(7);

        System.out.println(findDiameter(root));
    }

}
