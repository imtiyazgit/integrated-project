package algos.graph.biparte;
import java.util.*;

public class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> color = new HashMap<>();

    public boolean isBipartite(int[][] edges) {

        for(int i =0; i<edges.length; i++) {
            List<Integer> list = new ArrayList();

            for(Integer ele : edges[i]) {
                list.add(ele);
                color.put(ele, -1);
            }

            graph.put(i, list);
        }

        for(int i:graph.keySet()) {
            if(color.get(i) == -1) {
                if(bfs(i) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean bfs(int u) {
        Queue<Integer> q = new LinkedList<>();
        color.put(u, 0);
        q.add(u);
        while(!q.isEmpty()) {
            int cur = q.poll();
            int curColor = color.get(cur);

            for(int neigh: graph.get(cur)) {
                if(curColor == color.get(neigh)) {
                    return false;
                }

                if(color.get(neigh) == -1 && curColor != color.get(neigh)) {
                    q.add(neigh);
                    color.put(neigh, 1-curColor);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(solution.isBipartite(a));
    }
}
