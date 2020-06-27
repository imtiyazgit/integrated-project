package algos.queue.binarylinebylinetraversalVariant2.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *                       314
*                  6            6
*             271     561    2       271
 *         28    0      3     1        28
 *                    17    401  257
 *                           641
 *
 * Left to right Alternate
 * 1 left to right ->  314
 * 2 right to left -> 6 6
 * 3 left to right -> 271 561 2 271
 * 4 right to left -> 28 1 3 0 28
 * 5 left to right -> 17 401 257
 * 6 right to left -> 641
 */
public class LineByLineTreeDepthPrintAlternateLeftToRight {

    public static List<List<Integer>> lineByLineTreeDepthPrintAlternate(TreeNode treeNode) {
        if (treeNode == null) throw new IllegalArgumentException("Invalid input");

        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> rowNodes = List.of(treeNode);
        int rowNr = 1;
        while (!rowNodes.isEmpty()) {
            List<Integer> rowIntegers = null;
            // populate the results
            if (rowNr %2 == 1) {
                rowIntegers = rowNodes.stream().map(cur -> cur.data).collect(Collectors.toList());
            } else {
                // if its even, right to left
                rowIntegers = rowNodes.stream().map(cur -> cur.data).collect(Collectors.toList());
                Collections.reverse(rowIntegers);
            }

            result.add(rowIntegers);

            rowNr++;
            rowNodes = rowNodes.stream().map(cur -> Arrays.asList(cur.left, cur.right)).flatMap(List::stream).filter(cur->cur!= null).collect(Collectors.toList());
        }

        return result;
    }



    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        List<List<Integer>> results = lineByLineTreeDepthPrintAlternate(root);
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
