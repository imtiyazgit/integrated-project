package algos.number;

public class NaNExamples {
    public static void main(String[] args) throws Throwable {
        double x= 1;

        System.out.println(x!=x); // false

        System.out.println(Double.isNaN(x)); // false

        x = Double.NaN;

        System.out.println(Double.isNaN(x)); // true
        System.out.println(x!=x); // true

        x = 0.0/0.0;

        System.out.println(Double.isNaN(x)); // true

        x = Double.POSITIVE_INFINITY * 0;
        System.out.println(x); // Prints NaN

        x = 0.0/0;
        System.out.println(x); // Prints NaN

        x = Math.sqrt(-1);
        System.out.println("Math.sqrt(-1)" + x); // Prints NaN

        x = Math.log(-1);
        System.out.println("Math.log(-1)"+x); // Prints NaN

        System.out.println(2+Double.NaN); // Prints NaN

        Thread.sleep(1000);
        x = 0/0; // this will be int. This will throw ArithmeticException
        System.out.println(x);


    }
}
