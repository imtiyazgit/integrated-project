package algos.number;

// To multiply or divide a number by 2 without using '*' or '/' operator.
// Use, shift operator
// If the number is shifted once to right, its half
// If the number is shifted once to left, its doubled
public class DivMulBy2 {
    public static void main(String[] args) {
        int num = 100;
        int doubled =  num << 1;
        int halved = num >> 1;
        System.out.println(doubled);
        System.out.println(halved);
    }
}
