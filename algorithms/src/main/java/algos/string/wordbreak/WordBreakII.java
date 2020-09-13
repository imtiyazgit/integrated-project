package algos.string.wordbreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreakII {
    //s = "catsanddog"
    //wordDict = ["cat", "cats", "and", "sand", "dog"]
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, new HashMap<String, List<String>>());
    }

    private static List<String> wordBreakHelper(String s, List<String> wordDict, HashMap<String, List<String>> map) {

        if(map.containsKey(s)) {
            return map.get(s);
        }

        List<String> results = new ArrayList<>();
        if(s.isEmpty()) {
            results.add("");
            return results;
        }
        for(String word: wordDict) {
            if(s.startsWith(word)) {
                List<String> subStrings = wordBreakHelper(s.substring(word.length()), wordDict, map);

                for(String subString : subStrings) {
                    String spaceOptional = !subString.isEmpty() ? " " : "";
                    results.add(word + spaceOptional +subString);
                }
            }

        }

        map.put(s, results);
        return results;
    }


    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = new String[]{"cat", "cats", "and", "sand", "dog"};
        System.out.println(wordBreak(s, Arrays.asList(wordDict)));
    }


}
