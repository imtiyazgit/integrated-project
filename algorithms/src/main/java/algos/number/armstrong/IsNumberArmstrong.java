package algos.number.armstrong;

/**
 * Input: 153 If cubes of each digit is equal to the number, then its armstrong
 * 1*1*1 = 1
 * 5*5*5 = 125
 * 3*3*3 = 27
 * Sum of all these is 153, so its a armstrong.
 */
public class IsNumberArmstrong {

    // 153
    private static boolean isArmString(int n) {
        int temp = n;
        int sum =0;

        while (n>0) {

            int remainder = n % 10; // 3 -> 27

            sum += remainder * remainder * remainder;

            n = n/10;
        }

        if (temp == sum){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isArmString(153));
    }
}
