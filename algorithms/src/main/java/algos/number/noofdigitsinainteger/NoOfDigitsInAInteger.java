package algos.number.noofdigitsinainteger;

public class NoOfDigitsInAInteger {

    private static int noOfDigitsUsingIterative(Integer n) {

        if(n==null) {
            return 0;
        }

        int result=0;
        while(n>0) {
            result++;
            n = n/10;
        }

        return result;
    }

    private static int noOfDigitsUsingRecursive(Integer n) {
        if(n == null) {
            return 0;
        }

        if (n==0) {
            return 0;
        }

        return noOfDigitsUsingRecursive(n/10) + 1;
    }


    private static int noOfDigitsUsingBuiltInFunction(Integer n) {
        if (n == null) {
            return 0;
        }

        return String.valueOf(n).length();
    }

    public static void main(String[] args) {
        int n= 12343453;

        System.out.println(noOfDigitsUsingIterative(n));

        System.out.println(noOfDigitsUsingRecursive(n));

        System.out.println(noOfDigitsUsingBuiltInFunction(n));
    }
}
