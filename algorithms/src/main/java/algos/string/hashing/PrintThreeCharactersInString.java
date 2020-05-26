package algos.string.hashing;

public class PrintThreeCharactersInString {


    public static void main(String[] args) {
        String s = "ImtiyazBaigMoghal";

        // no of characters to print
        int m = 3;

        for(int i=0;i < s.length() -2; i++) {
            String substring = s.substring(i, i+m); // substring second argument takes index exclusive
            System.out.println(substring);
        }
    }
}
