package algos.number.numToRoman;

import java.util.Map;

public class RomanAllQuestions {
    private static Map<Character, Integer> romanValues = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);



    // Convert roman to integer IV
    private static int romanToInteger(String s) {
        if (s== null || s.length()==0) throw new IllegalArgumentException("Invalid input");

        // iterate from backside.. Romans typically will be increasing from backside
        // If it decreases, then it means, it should be part of 6 exceptions: IV, IX, XL, XC, CD, CM which has to be subtracted

        // First get the last roman
        int sum = romanValues.get(s.charAt(s.length()-1));

        for (int i = s.length()-2; i >=0 ; i--) {
            // Romans should be increasing from backside. So add to sum
            // You are actually comparing this element to its right. For example, IV, at I, you are comparing with V which is right side element
            if(romanValues.get(s.charAt(i)) > romanValues.get(s.charAt(i+1))) {
                // if roman value at i is greater than its right roman value, then its increasing roman. add up
                sum+= romanValues.get(s.charAt(i));
            } else {
                // this i roman value is decreasing to its right element. so subtract. for example IV. At I, its actually decreasing from V
                sum-= romanValues.get(s.charAt(i));
            }
        }

        return sum;
    }



    public static void main(String[] args) {
        System.out.println(romanToInteger("L")); // 50
        System.out.println(romanToInteger("LX")); // 60
        System.out.println(romanToInteger("DL")); // 550
        System.out.println(romanToInteger("LIX")); // 59
        System.out.println(romanToInteger("MCMIV")); // 1904
    }
}
