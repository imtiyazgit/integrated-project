package algos.number.numToRoman;

/**
 * integerToRoman(1) == "I"
 * integerToRoman(4) == "IV"
 * integerToRoman(49) == "XLIX"
 */
public class ConvertNumToRoman {

    private static final String[] numerals = new String[] {
            "M", "DM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    private static final int[] values =  new int[] {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    /**
     * Linear run time = O(n)
     * Greedy algorithm as it runs through the array to until value is greater than 0
     *
     */
    private static String integerToRoman(int value) {

        // sanity check 1 to 3999
        if(value > 3999 || value < 1) {
            throw new IllegalArgumentException("Input must be between 1 to 3999");
        }

        // Initialize a empty string, start removing biggest value in order, 1000 followed by 500, etc
        StringBuilder numeral = new StringBuilder();

        int i=0;

        while(value>0) {

            // Remove biggest value from value
            if (value - values[i] >= 0) {
                numeral.append(numerals[i]);
                value -= values[i];
            } else {
                i++;
            }

        }

        return numeral.toString();

    }


    public static void main(String[] args) {


        System.out.println(integerToRoman(99)); // XCIX --> X10 C100 -> 90 + IX
        System.out.println(integerToRoman(4));
        System.out.println(integerToRoman(49));
    }
}
