package algos.tree.traversal.treetraversalpractice;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

public class BST {

    public TreeNode insert(TreeNode node, int data) {
        if(node == null) {
            TreeNode newNode = new TreeNode(data);
            return newNode;
        }

        if(data > node.data) {
            node.right = insert(node.right, data);
        } else {
            node.left = insert(node.left, data);
        }

        return node;
    }


}
