package algos.tree.lca;

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

/**
 *       7
 *   8      9
 * 4   6
 *    2  11
 */
public class FindLCA {

    //  4 and 11
    private static TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null) {
            return null;
        }

        if(root == node1 || root == node2) {
            return root;
        }

        TreeNode left = findLCA(root.left, node1, node2);
        TreeNode right = findLCA(root.right, node1, node2);

        if(left != null && right != null) {
            return root;
        } else {
            // return null if both are leaf nodes
            // if one is available return that
            return left != null ? left : right;
        }

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(7);
        binaryTree.root.left = new TreeNode(8);
        binaryTree.root.right = new TreeNode(9);
        binaryTree.root.left.left = new TreeNode(4);
        binaryTree.root.left.right = new TreeNode(6);
        binaryTree.root.left.right.left = new TreeNode(2);
        binaryTree.root.left.right.right = new TreeNode(11);

        System.out.println(findLCA(binaryTree.root, binaryTree.root.right, binaryTree.root.left.right.right).data);

    }
}
