package algos.queue.binarylinebylinetraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreeDepthOrderOrLineByLinePrint {
    public static List<List> binaryTreeDepthOrder(TreeNode root) {
        List<List> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        List<TreeNode> currDepthNodes = List.of(root);
        while(!currDepthNodes.isEmpty()) {
            result.add(currDepthNodes.stream().map(curr -> curr.data).collect(Collectors.toList()));
            currDepthNodes = currDepthNodes.stream()
                    .map(curr -> Arrays.asList(curr.left, curr.right))
                    .flatMap(List::stream)
                    //.flatMap(curr -> curr.stream())
                    .filter(child -> child != null)
                    .collect(Collectors.toList());
        }

        return result;
    }



    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        List<List> results = binaryTreeDepthOrder(root);
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
