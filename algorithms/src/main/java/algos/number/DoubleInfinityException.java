package algos.number;

public class DoubleInfinityException {
    public static void main(String[] args) {
        double d = 1.0/0.0;

        Double d2 = 1.0/0.0;

        System.out.println(d); // Prints Infinity
        System.out.println(d2); // Prints Infinity
    }
}
