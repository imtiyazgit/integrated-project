package algos.number;

// Swap using without temp variable
public class Swap {
    public static void main(String[] args) {
        int a=1; int b=2;

        // General swap using temp variable
        int temp = a;
        a=b;
        b=temp;
        System.out.println(a +" and "+b);

        a=1;
        b=2;

        // swap using + -
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println(a +" and "+b);

        // swap using bitwise operator
        a=1; b=2;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a +" and "+b);

        // swap using * and /
        a=1; b=2;
        a = a*b;
        b = a/b;
        a = a/b;
        System.out.println(a +" and "+b);
    }
}
