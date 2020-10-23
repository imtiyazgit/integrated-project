package algos.number;

public class Test {

    private static final String[] THOUSANDS = {"", "THOUSANDS", "MILLION", "BILLION"};
    // 32.424.124.324
    // thirty two billion
    // four hundred twenty four million
    public static String numberToWords(int num) {
        int index =0;
        StringBuilder result = new StringBuilder();
        while(num >0) {
            StringBuilder temp = new StringBuilder();
            convert(num%1000, temp);
            temp.append(THOUSANDS[index]).append(" ");
            result.insert(0, temp);
            index++;
            num = num/1000;
        }
        return result.toString();
    }

    private static final String[] LESS_THAN_TWENTY = {"", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"
    , "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"};
    private static final String[] TENS = {"", "", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};
    // 324
    // 0 to 20
    // 20 to 99
    // 100 to 999
    public static void convert(int num, StringBuilder sb) {
        if(num == 0) return;

        if(num < 20) {
            sb.append(LESS_THAN_TWENTY[num]).append(" ");
        } else if(num < 100) {
            // 24
            sb.append(TENS[num/10]).append(" ");
            convert(num%10, sb);
        } else {
            // 324
            sb.append(LESS_THAN_TWENTY[num/100]).append(" HUNDRED ");
            convert(num%100, sb);
        }
    }

    public static void main(String[] args) {
        //System.out.println(numberToWords(123));
        //System.out.println(numberToWords(102));
        System.out.println(numberToWords(1234567891));
    }
}
