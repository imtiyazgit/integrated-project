package algos.string;

public class InterestingChar {

    public static void main(String[] args) {
        char c = 'a';
        System.out.println(c); // this prints a

        int i = c; // The moment you assign a char to integer, it will assign its ascii value
        System.out.println(i); // should print 97

        char c2 = '1';
        int c2ascii= c2;
        int c2Numeric = Character.getNumericValue(c2);
        System.out.println(c2ascii);
        System.out.println(c2Numeric);
    }
}
