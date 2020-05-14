package algos.string.conversion;

/**
 * Excel spreadsheet columns look like A, B, C, ... Z, AA, AB, AC,...AZ, BA, BB, BC, ... BZ, CA, ...
 *
 * You need to get the integer id for the input column name
 *
 * A - 1
 * B - 2
 * C - 3
 * .
 * .
 * .
 * Z - 26
 * AA - 27
 * AB - 28
 * .
 * .
 * AZ - 52 i..e 26+26
 * BA - 53
 * BB - 54
 * BC - 55
 * .
 * .
 * .
 * ZZ - Here the left first Z to reach you have to replace 26 times and right Z to reach you have to replace 26 times
 * therefore, its basically number system to 26
 * So, to reach to ZZ - 26 power of 2 + 26
 *
 * ZZZ - 26^3 + 26^2 + 26
 *
 * its very similar to {@link StringToInt} "123" --> 0 * 10 + 1= 1
 *                                                   1 * 10 + 2 = 12, etc
 * However, in this problem, the base is 26
 * Therefore, 0 * 26 + 26 = 26
 *            26 * 26 + 26 = 26^2 + 26
 *            26 * 26 * 26 + 26 = 26
 *
 * The last addition of  + 26 can be any thing like +1 for A or +2 for B, etc
 *
 * So, the trick here is : runningTotal * 26 + Value of Char i.e. A/B/C capital
 *                         runningTotal * 26 + c - 'A' + 1 --> +1 added here because A is counted as 1
 *
 *
 */
public class ComputeSpreadSheetColumnEncoding {

    // 1 - A
    // 26 -- Z
    // 27 -- AA
    private static String getColumnEncodingFromInteger(int x) {
        StringBuilder result = new StringBuilder();

        while(x!=0) {
            int remainder = x %26 ;// if remainder is zero, then its Z.
            if(remainder == 0) {
                // Its edge at Z. Directly add this..
                result.append("Z");
                x = x/26;
                // Since 1 will be left out as x value, it will go for one more round. Stop this by subtracting with 1 at edge
                x--;
            } else {
                int ascii = 'A' + remainder -1;
                result.append((char) ascii);
                x = x/26;
            }

        }

        return result.reverse().toString();
    }


    private static int getColumnEncodingInteger(String column) {
        if(column == null || column.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid column!");
        }

        char[] chars = column.toCharArray();

        int runningTotal = 0;
        for (int i = 0; i < chars.length; i++) {
            runningTotal = runningTotal * 26 + chars[i] - 'A' + 1;
        }

        return runningTotal;
    }

    public static void main(String[] args) {



        System.out.println(getColumnEncodingInteger("A")); // 1
        System.out.println(getColumnEncodingInteger("Z")); // 26
        System.out.println(getColumnEncodingInteger("AA")); //27
        System.out.println(getColumnEncodingInteger("AZ")); //52
        System.out.println(getColumnEncodingInteger("ZZ")); // left digit 26 times 26 or 26 ^ 26 + 26 --> 702



        System.out.println(getColumnEncodingFromInteger(1));//A
        System.out.println(getColumnEncodingFromInteger(2));//B
        System.out.println(getColumnEncodingFromInteger(25));//Y
        System.out.println(getColumnEncodingFromInteger(26)); //Z
        System.out.println(getColumnEncodingFromInteger(27)); //AA
        System.out.println(getColumnEncodingFromInteger(51)); //AY

    }
}
