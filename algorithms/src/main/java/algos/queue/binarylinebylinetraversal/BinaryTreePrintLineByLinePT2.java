package algos.queue.binarylinebylinetraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *    3
 *  4    1
 *  1 2  99
 *  6
 *
 *  3, [4,1], [1,2,99], 6
 */
public class BinaryTreePrintLineByLinePT2 {

    public static List<List> printBinaryTreeLineByLine(TreeNode root) {
        List<List> results = new ArrayList<>();

        List<TreeNode> rowsToPrint = List.of(root);

        while(!rowsToPrint.isEmpty()) {
            results.add(rowsToPrint.stream().map(curr -> curr.data).collect(Collectors.toList()));

            rowsToPrint = rowsToPrint.stream()
                    .map(curr -> Arrays.asList(curr.left, curr.right))
                    .flatMap(List::stream)
                    .filter(curr -> curr != null)
                    .collect(Collectors.toList());
        }

        return results;
    }


    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        List<List> results = printBinaryTreeLineByLine(root);
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

