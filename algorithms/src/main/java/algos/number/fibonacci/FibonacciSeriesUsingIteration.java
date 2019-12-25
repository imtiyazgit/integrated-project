package algos.number.fibonacci;

public class FibonacciSeriesUsingIteration {

    private static void printFibonacciSeries(int maxNumber) {

        int previousNumber = 0;
        int nextNumber = 1;

        for (int i = 0; i < maxNumber; i++) { // how many iterations
            System.out.println(previousNumber);

            int sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
        }

    }

    public static void main(String[] args) {
        printFibonacciSeries(10);
    }
}
