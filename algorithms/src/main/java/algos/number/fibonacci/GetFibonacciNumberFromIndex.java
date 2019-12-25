package algos.number.fibonacci;


/**
Problem: Java Get Fibonacci Number by Index
 Series: 0  1   1   2   3   5   8   13
 Pos:    0  1   2   3   4   5   6   7

 fibonacci(6) -> 8
 fibonacci(7) -> 13

 */


public class GetFibonacciNumberFromIndex {

    private static int fibonacci(int n)  {
        if (n ==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }
}
