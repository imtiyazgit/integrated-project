package algos.queue.binarylinebylinetraversalVariant2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LineByLineAlternatingLeftToRight {
    public static List<List> alternatingLeftToRightLineByLinePrint(TreeNode root) {
        if (root == null) throw new IllegalArgumentException("Invalid input");

        List<List> results = new ArrayList<>();
        List<TreeNode> rowToPrint = List.of(root);

        var rowNrHolder = new Object() { public int rowNr=1;};

        while(!rowToPrint.isEmpty()) {
            List rowToAppend = rowToPrint.stream().map(cur -> cur.data).collect(Collectors.toList());
            if(rowNrHolder.rowNr %2 == 0) {
                // if even, right to left. so reverse it
                results.add(reverse(rowToAppend));
            } else {
                results.add(rowToAppend);
            }

            rowNrHolder.rowNr++; // row is printed.. so incremented

            // collect elements left to right if its odd

            rowToPrint = rowToPrint.stream()
                    .map(cur-> Arrays.asList(cur.left, cur.right)).flatMap(List::stream).filter(cur->cur!= null).collect(Collectors.toList());


        }

        return results;
    }

    private static List<Integer> reverse(List<Integer> input) {
        List<Integer> result = new ArrayList<>();
        for (int i = input.size()-1; i >=0 ; i--) {
            result.add(input.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        List<List> results = alternatingLeftToRightLineByLinePrint(root);
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
