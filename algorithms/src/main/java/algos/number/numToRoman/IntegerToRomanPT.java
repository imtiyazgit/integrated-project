package algos.number.numToRoman;

public class IntegerToRomanPT {

    private static String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static Integer[] values = new Integer[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};


    private static String integerToRoman(int x) {
        if(x < 1 || x > 3999) {
            throw new IllegalArgumentException("Input must be in the range 1-3999");
        }

        StringBuilder result = new StringBuilder();

        int i=0;
        while(x>0) {

            // subtract higher number first. If the result is greater than 0, add to result its roman
            if(x-values[i] >= 0) {
                x = x-values[i]; // subtract it from x and add its roman to the result
                result.append(romans[i]);
            } else {
                // You cant subtract higher roman value. Try next element
                i++;
            }

        }

        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(integerToRoman(4));
        System.out.println(integerToRoman(76));
        System.out.println(integerToRoman(444));
        System.out.println(integerToRoman(1900));
        System.out.println(integerToRoman(3500));
        System.out.println(integerToRoman(4200));
    }
}
