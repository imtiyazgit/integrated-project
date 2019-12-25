package algos.number.factorial;

public class FindFactorialUsingIteration {
    
    private static int factorial(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * i;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(factorial(n));
    }
}
