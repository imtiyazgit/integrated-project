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

        // how to convert number to a character
        // 65 is input --> output A
        System.out.println((char) 65); // A

        char test = Character.forDigit(0, 10); // Ascii value of 0 in base 10
        System.out.println(0 + test); //48

        // 0- A
        // 1 - B
        // Ascii table, 48-0 & 65-A & 97-a
        // To make 1 to A, add up diff. Diff here is 65-48=17
        System.out.println((char) (17 + Character.forDigit(0, 10)));

       //  char c2 = 'IV'; // compile error. too many characters for char literal

    }
}
