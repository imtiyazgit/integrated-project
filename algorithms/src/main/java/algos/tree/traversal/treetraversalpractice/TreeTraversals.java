package algos.tree.traversal.treetraversalpractice;

public class TreeTraversals {

    // currentNode, left and right
    private static void preOrder(TreeNode node) {
        if(node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Left, rootNode, Right
    private static void inOrder(TreeNode node) {
        if(node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    private static void postOrder(TreeNode node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    /**
     *        7
     *     5      9
     *   4  6    8  10
     *
     */
    public static void main(String[] args) {
        BST bst = new BST();
        TreeNode rootNode = bst.insert(null, 7);
        bst.insert(rootNode, 5);
        bst.insert(rootNode, 9);
        bst.insert(rootNode, 4);
        bst.insert(rootNode, 6);
        bst.insert(rootNode, 8);
        bst.insert(rootNode, 10);

        // preOrder result in 7 5 4 6 9 8 10
        preOrder(rootNode);

        // inOrder results in 4 5 6 7 8 9 10
        // inOrder(rootNode);

        // postOrder results in 4 6 5 8 10 9 7
        //postOrder(rootNode);

    }
}
