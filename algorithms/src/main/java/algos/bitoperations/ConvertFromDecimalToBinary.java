package algos.bitoperations;

public class ConvertFromDecimalToBinary {

    public static String fromJavaApi(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public static String convertWithoutUsingApi(int decimal, int base) {
        String result = "";

        while (decimal >0) {

            result += decimal%base;

            decimal = decimal/base;
        }

        return new StringBuilder(result).reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(fromJavaApi(125));
        System.out.println(convertWithoutUsingApi(125, 2));
    }



}
