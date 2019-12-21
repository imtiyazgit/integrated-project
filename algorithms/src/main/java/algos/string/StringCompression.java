package algos.string;

public class StringCompression {

    private static String compress(String string) {

        String result = "";
        int counter=1;
        for (int i = 0; i < string.length() -1; i++) {
            if(string.charAt(i) != string.charAt(i+1)) {
                result = result + string.charAt(i) + counter;
                counter = 1;
                continue;
            }
            ++counter;
        }

        result = result + string.charAt(string.length()-1) + counter;

        return result.length() > string.length() ? string : result;

    }

    public static void main(String[] args) {
        String string = "aaa";
        System.out.println(compress(string));
    }
}
