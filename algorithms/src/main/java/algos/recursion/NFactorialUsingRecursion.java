package algos.recursion;

public class NFactorialUsingRecursion {

    private static int fact(int n) {
        if(n==1) {
            return 1;
        } else {
            return n * fact(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Factorial result of 5 is "+fact(5));
    }
}
