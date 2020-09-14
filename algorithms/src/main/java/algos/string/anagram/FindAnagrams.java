package algos.string.anagram;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int[] char_counts =  new int[26];

        for(char c:p.toCharArray()) {
            char_counts[c-'a']++;
        }

        int left=0;
        int right=0;
        int count = p.length();

        while(right < s.length()) {
            char c = s.charAt(right);
            System.out.println(c);
            if(char_counts[s.charAt(right++) - 'a']-- >= 1) {
                count--;
            }

            if(count ==0 ) {
                result.add(left);
            }

            c = s.charAt(left);
            System.out.println(c);
            if(right - left == p.length() && char_counts[s.charAt(left++) - 'a']++ >=0) {
                count++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "dafg";
        String p = "abc";

        List<Integer> results = findAnagrams(s, p);
        System.out.println(results);
    }
}
