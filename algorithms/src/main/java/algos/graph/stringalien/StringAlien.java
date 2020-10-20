package algos.graph.stringalien;
import java.util.*;

public class StringAlien {

    public String alienOrder(String[] words) {
        int[] inDegree = new int[26];
        Map<Character, List<Character>> graph = new HashMap();

        for(String word:words) {
            for(char c: word.toCharArray()) {
                graph.put(c, new ArrayList());
            }
        }

        for(int i=0; i<words.length-1;i++) {
            String start = words[i];
            String end = words[i+1];

            if(start.length() > end.length() && start.startsWith(end)) {
                return "";
            }
            int len = Math.min(start.length(), end.length());
            for(int j=0;j<len; j++) {
                // wrt
                // wrf
                // t -> f
                char out = start.charAt(j);
                char in = end.charAt(j);
                if(out != in) {
                    graph.get(out).add(in);
                    inDegree[in - 'a']++;
                    // f -> 1
                    break;
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList();
        for(char c:graph.keySet()) {
            if(inDegree[c - 'a'] == 0) {
                q.add(c);
            }
        }

        while(!q.isEmpty()) {
            char out = q.poll();
            sb.append(out);
            for(char in : graph.get(out)) {
                if(--inDegree[in - 'a'] == 0) {
                    q.add(in);
                }
            }
        }

        return sb.length() == graph.size() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        StringAlien stringAlien = new StringAlien();
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(stringAlien.alienOrder(words));
    }
}
