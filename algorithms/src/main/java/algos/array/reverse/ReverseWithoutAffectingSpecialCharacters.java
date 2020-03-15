package algos.array.reverse;

public class ReverseWithoutAffectingSpecialCharacters {

    // Simple solution
    // Input = a,b$c
    // Output= c,b$a
    // Algorithm -> temp : abc and reverse cba
    // go through input -> if a char, replace from temp and otherwise not
    // Time Complexity: O(n) + O(n)= O(n+n) = O(2n)
    // Space Complexity: O(n) for temp array
    private static String reverseWithoutAffectingSpecialChars(String str) {
        StringBuilder temp = new StringBuilder();

        for (char c: str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                temp.append(c);
            }
        }

        temp.reverse();

        char[] chars = str.toCharArray();

        for (int i = 0, j=0; i < chars.length; i++) {
            if(Character.isAlphabetic(chars[i])) {
                chars[i] = temp.charAt(j++);
            }
        }


        return new String(chars);

    }



    private static String reverseUsingSingleLoop(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length -1;

        while(i<j) {
            if(!Character.isAlphabetic(chars[i])) {
                i++;
            } else if(!Character.isAlphabetic(chars[j])) {
                j--;
            } else {
                // Swap
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++; j--;
            }
        }

        return new String(chars);

    }

    public static void main(String[] args) {
        String input =  "a,b$c";

        System.out.println(reverseWithoutAffectingSpecialChars(input));

        System.out.println(reverseUsingSingleLoop(input));
    }
}
