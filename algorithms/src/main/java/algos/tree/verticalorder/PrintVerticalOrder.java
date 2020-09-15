package algos.tree.verticalorder;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

class Point {
    int data;
    int x;
    int y;

    public Point(int data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }
}

public class PrintVerticalOrder {

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Point> list = new ArrayList<>();
        vtUtil(root, 0, 0, list);

        Collections.sort(list, (p1, p2) -> {
            if (p1.x == p2.x) {
                if (p1.y == p2.y) {
                    // if p1 and p2 points are on same line, then element which is less should come first
                    return p1.data - p2.data;
                } else {
                    // same
                    return p2.y - p1.y;
                }
            } else {
                return p1.x - p2.x;
            }
        });

        // {-2:[4]
        //  -1:[2]
        //   0:[1,5,6]
        //   1: [3]
        //   2: 7}
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (Point p : list) {
            List<Integer> line = treeMap.getOrDefault(p.x, new ArrayList<>());
            line.add(p.data);
            treeMap.put(p.x, line);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> l : treeMap.values()) {
            result.add(l);
        }

        return result;

    }

    private static void vtUtil(TreeNode root, int x, int y, List<Point> list) {
        if (root == null) {
            return;
        }

        Point point = new Point(root.data, x, y);
        list.add(point);
        vtUtil(root.left, x-1, y-1, list);
        vtUtil(root.right, x+1, y-1, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> results = verticalTraversal(root);

        System.out.println(results);
        /*for(List<Integer> listItem : results) {
            System.out.println();
        }*/

    }
}
