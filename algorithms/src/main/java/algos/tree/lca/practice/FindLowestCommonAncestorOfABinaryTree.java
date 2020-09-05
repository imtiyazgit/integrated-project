package algos.tree.lca.practice;

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
 *        6
 *     4       7
 *   9   13
 *  2  5
 *
 *  LCA of 9 and 13 --> 4
 *  LCA of 9 and 5 --> 9
 */
public class FindLowestCommonAncestorOfABinaryTree {

    private static TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        // base condition
        if(root == null) {
            return null;
        }

        if(root == node1 || root == node2) {
            return root;
        }

        TreeNode left = findLCA(root.left, node1, node2);
        TreeNode right = findLCA(root.right, node1, node2);

        // what you are going to do with this node
        if(left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(6);
        binaryTree.root.left = new TreeNode(4);
        binaryTree.root.right = new TreeNode(7);
        binaryTree.root.left.left = new TreeNode(9);
        binaryTree.root.left.right = new TreeNode(13);
        binaryTree.root.left.left.left = new TreeNode(2);
        binaryTree.root.left.left.right = new TreeNode(5);

        System.out.println(findLCA(binaryTree.root, binaryTree.root.left.left, binaryTree.root.left.left.right).data);
    }

}
