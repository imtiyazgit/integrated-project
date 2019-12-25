package algos.string;

public class SubStringReturnsEmptyStringExactlyAtLengthOfString {
    public static void main(String[] args) {
        String message = "abc";
        System.out.println(message.substring(3)); // Returns empty string
        //System.out.println(message.substring(4)); // Returns Out of bounds exception
    }
}
