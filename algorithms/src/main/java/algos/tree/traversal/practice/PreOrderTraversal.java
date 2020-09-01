package algos.tree.traversal.practice;

public class PreOrderTraversal {

    public static void preOrderTraversal(TreeNode node) {
        if(node != null) {
            System.out.println(node.data);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);

        }
    }

    public static void inOrderTraversal(TreeNode node) {
        if(node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);

        }
    }

    public static void postOrderTraversal(TreeNode node) {
        if(node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.data);
        }
    }


    public static void main(String[] args) {
        BST bst = new BST();
        TreeNode root = bst.insertUsingRecursion(null, 7);
        bst.insertUsingRecursion(root, 9);
        bst.insertUsingRecursion(root, 5);
        bst.insertUsingRecursion(root, 10);
        bst.insertUsingRecursion(root, 8);
        bst.insertUsingRecursion(root, 6);
        bst.insertUsingRecursion(root, 4);

        //preOrderTraversal(root);

        //inOrderTraversal(root);

        postOrderTraversal(root);


    }
}
