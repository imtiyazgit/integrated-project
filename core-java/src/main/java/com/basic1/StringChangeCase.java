package main.java.com.basic1;

public class StringChangeCase {

    // Just add/remove 32 to the character
    static char changeCase(char ch) {
        int difference = 32;
        if (ch>=97 && ch<=122) {
            ch -= difference;
        } else if(ch>=65 && ch<=90) {
            ch += difference;
        }
        return ch;
    }

    public static void main(String[] args) {
        String str = "hello";
        for (char c:str.toCharArray()) {
            System.out.print(changeCase(c));
        }
    }
}
