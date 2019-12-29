package algos.bitoperations;

public class XorStriking {
    public static void main(String[] args) {

        System.out.println(0^0); // Is exlusive or? Prints 0

        System.out.println(1^0); // Is exlusive or? Yes, Prints 1

        System.out.println(1^1); // Is exclusive or? No, prints 0

        System.out.println(0^1); // Prints Yes, 1

        System.out.println(2^2); // prints 0

        System.out.println(2^3^2); // prints 3

        // boolean dieselXorManual = (car.isDiesel() && !car.isManual()) || (!car.isDiesel() && car.isManual());

        // boolean dieselXorManual = car.isDiesel() ^ car.isManual();

        System.out.println(2^3);
        //System.out.println();
    }
}
