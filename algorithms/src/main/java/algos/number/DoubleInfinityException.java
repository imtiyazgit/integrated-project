package algos.number;

public class DoubleInfinityException {
    public static void main(String[] args) throws Throwable {
        double d = 1.0/0.0;

        Double d2 = 1.0/0.0;

        System.out.println(d); // Prints Infinity
        System.out.println(d2); // Prints Infinity

        Thread.sleep(1000);
        int i = 1/0; // Throws arithmetic exception
        System.out.println(i);
    }
}
