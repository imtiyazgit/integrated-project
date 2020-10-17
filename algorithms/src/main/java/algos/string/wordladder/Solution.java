package algos.string.wordladder;

import java.util.*;

public class Solution {

    // beginWord = "hit
    // endWord = "cog"
    // wordList = ["hot","dot","dog","lot","log","cog"]
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                String current_word = queue.poll(); // hit
                char[] word_chars = current_word.toCharArray();

                for (int j = 0; j < word_chars.length; j++) {
                    char original_char = word_chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (original_char == c) continue;
                        word_chars[j] = c;
                        String new_word = new String(word_chars);
                        if (new_word.equals(endWord)) {
                            return level + 1;
                        }
                        if (set.contains(new_word) && !new_word.equals(current_word)) {
                            queue.offer(new_word);
                            set.remove(new_word);
                            break;
                        }
                    }
                    word_chars[j] = original_char;
                }

            }
            level++;
        }

        return 0;
    }

    public int ladderLengthWordking(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int res = 0;

        while(!q.isEmpty()) {
            for(int k=q.size(); k>0; k--) {
                String word = q.poll(); // hit
                if(word.equals(endWord)) {
                    return res+1;
                }
                for(int i=0;i<word.length();++i) {
                    char[] newWord = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        newWord[i] = ch;
                        String s = new String(newWord);
                        if (wordSet.contains(s) && !s.equals(word)) {
                            q.offer(s);
                            wordSet.remove(s);
                        }
                    }
                    System.out.println("char completed. try another char");
                }
                System.out.println("this word completed");
            }
            ++res;
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        Solution solution = new Solution();
        System.out.println(solution.ladderLengthWordking("lost", "cost", Arrays.asList("most","fist","lost","cost","fish")));
    }
}
