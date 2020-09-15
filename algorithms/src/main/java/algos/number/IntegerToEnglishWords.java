package algos.number;

public class IntegerToEnglishWords {

    public static String[] NUM_LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven","Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public static String[] TENS = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public static String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder res = new StringBuilder();

        int index =0;
        while(num > 0) {
            StringBuilder sb = new StringBuilder();
            convert(sb, num%1000);
            res.insert(0, sb.append(THOUSANDS[index])).append(" ");
            num = num/1000;
            index++;
        }

        return res.toString().trim();
    }


    private static void convert(StringBuilder sb, int num) {
        if(num == 0) return;

        if(num < 20) {
            //15
            sb.append(NUM_LESS_THAN_TWENTY[num]).append(" ");
        } else if(num < 100) {
            //89
            sb.append(TENS[num/10]).append(" ");
            convert(sb, num%10);
        } else {
            // 121
            sb.append(NUM_LESS_THAN_TWENTY[num/100]).append(" Hundred ");
            convert(sb, num%100);
        }
    }

    public static void main(String[] args) {
        //System.out.println(numberToWords(123));
        //System.out.println(numberToWords(102));
        System.out.println(numberToWords(1234567891));
    }
}
