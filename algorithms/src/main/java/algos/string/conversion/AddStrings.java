package algos.string.conversion;

public class AddStrings {

    // 13
    // 29
    // 42
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        char[] num1Arr = num1.toCharArray();
        int num1Index = num1.length()-1;

        char[] num2Arr = num2.toCharArray();
        int num2Index = num2.length()-1;
        int carry = 0;
        while(num1Index >= 0 || num2Index >=0) {
            int sum = carry + (num1Arr[num1Index] - '0') + (num2Arr[num2Index] - '0');
            result.append(sum%10);
            carry = sum/10;
            num1Index--;
            num2Index--;
        }

        /*if(carry != 0) {
            result.append(carry);
        }*/

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("2", "99"));
    }
}
