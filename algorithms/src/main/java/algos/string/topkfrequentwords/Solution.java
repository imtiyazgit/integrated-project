package algos.string.topkfrequentwords;

import java.util.*;

public class Solution {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> {
            int t1 = count.get(w1);
            int t2 = count.get(w2);
            if(count.get(w1).equals(count.get(w2))) {
                return w1.compareTo(w2);
            } else {
                return count.get(w2) - count.get(w1);
            }
        });

        return candidates.subList(0, k);
    }

    public static void main(String[] args) {
        String[] input = {"i", "love", "leetcode", "i", "love", "coding", "i"};
        System.out.println(topKFrequent(input, 2));
    }
}
