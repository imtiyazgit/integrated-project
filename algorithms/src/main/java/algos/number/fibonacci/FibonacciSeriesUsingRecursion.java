package algos.number.fibonacci;

    /**
     * 0 1 1 2 3 5 8
     */
    public class FibonacciSeriesUsingRecursion {

        private static int fibonacci(int n) {
            if (n==0) {
                return 0;
            } else if(n==1) {
                return 1;
            }

            return fibonacci(n-2) + fibonacci(n-1);
        }


        public static void main(String[] args) {

            int howManyNumbers = 10;

            for (int i = 0; i < howManyNumbers; i++) {
                System.out.println(fibonacci(i));
            }

        }

    }
