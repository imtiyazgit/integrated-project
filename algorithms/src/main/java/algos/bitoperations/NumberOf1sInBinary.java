package algos.bitoperations;

public class NumberOf1sInBinary {

    private static int numberOf1s(int x) {
        int noOf1s=0;

        while (x>0) {

            if(x%2 == 1) {
                // right most bit is 1
                noOf1s++;
            }

            // right shift x until it becomes 0
            //x= x >> 1;

            // same as

            x= x/2;
        }

        return noOf1s;

    }

    public static void main(String[] args) {

        int x=125;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(numberOf1s(x));

    }
}
