package algos.tree.serializedeserialize;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
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

public class SerDeserTree {

    //      10
    //   5        15
    // 3  7         18
    public static String serialize(TreeNode root) {
        // perform dfs pre order traversal; node left right 10 5 3 null null 7 15 null 18 null null
        if(root == null) {
            return "X,";
        }
        String node = root.data + ",";
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);

        return node + leftSerialized + rightSerialized;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String serializedData) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(serializedData.split(",")));

        return deserializeHelper(queue);
    }

    public static TreeNode deserializeHelper(Queue<String> queue) {
        String nodeVal = queue.remove();
        if(nodeVal.equals("X")) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.valueOf(nodeVal));
        newNode.left = deserializeHelper(queue);
        newNode.right = deserializeHelper(queue);
        return newNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left =new TreeNode(5);
        root.left.left =new TreeNode(3);
        root.left.right =new TreeNode(7);

        root.right =new TreeNode(15);
        root.right.right =new TreeNode(18);

        String serialized = serialize(root);
        System.out.println(serialized);

        TreeNode dRoot = deserialize(serialized);
        System.out.println(dRoot);
    }
}
