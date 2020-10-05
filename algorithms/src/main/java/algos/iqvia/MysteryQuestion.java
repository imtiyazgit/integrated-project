package algos.iqvia;

public class MysteryQuestion {

    // I guess, its a telephone pad which can be used in mobile phone banking for dialing purposes
    // for example 2 typically maps to abc, 3 maps to def, 4 maps to ghi, etc
    // Below code accepts 10 digit string containing either a numeric or a letter.
    // If its numeric, it just adds to the result
    // If its letter, this is where the conversion from letter to ascii value and grouping to the respective number is done
    // Time complexity: O(n) since each element character is processed once
    // Space complexity: O(n) for storing the character in the result
    public static String function(String s) {
        // Throwing run time exception if given string is not of length 10 characters
        if (s.length() != 10) {
            throw new RuntimeException();
        }
        StringBuffer sb = new StringBuffer();
        // Iterating 10 times 0 to 9 inclusive and processing the string characters inside the loop
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                // when i is at index 0, sb is added with opening bracket
                sb.append('(');
            } else if (i == 3) {
                // when i is at index 3, sb is added with closing bracket
                sb.append(')');
            } else if (i == 6) {
                // when i is at index 6, sb is added with closing hyphen
                sb.append('-');
            }
            // Fetching the character at ith location of given s
            char c = s.charAt(i);

            // If the character is a digit
            if (Character.isDigit(c)) {
                // digit is added to the resulting string
                sb.append(c);
            } else if (Character.isLetter(c)) {
                // if its a letter, ascii value of the character is fetched with mapping a->0, b->1, etc
                char c1 = (char) (Character.toLowerCase(c) - 'a');

                // Conversion to resemble telephone pad
                // abc - 2
                // def - 3
                // ghi - 4, etc
                char c2 = (char) (((int) '2') + (c1 / 3));

                // Finally converted letter to numeric value is being added to the result set
                sb.append(c2);
            } else {
                // If the character at i is not a digit or letter, throw run time exception
                throw new RuntimeException();
            }
        }
        // convert string buffer to string
        return sb.toString();
    }

}

