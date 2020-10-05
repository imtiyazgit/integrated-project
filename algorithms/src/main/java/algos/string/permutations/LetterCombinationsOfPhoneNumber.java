package algos.string.permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    private String[] mapping = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        letterCombinationsRecursive(digits, "", 0, result);
        return result;
    }

    private void letterCombinationsRecursive(String digits, String current,int index, List<String> results) {
        if(index == digits.length()) {
            results.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsRecursive(digits, current + letters.charAt(i), index+1, results);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
        List<String> results = letterCombinationsOfPhoneNumber.letterCombinations("23");
        results.stream().forEach(str -> System.out.println(str));
    }
}
