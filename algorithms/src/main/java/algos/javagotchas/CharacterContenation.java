package algos.javagotchas;

public class CharacterContenation {
    public static void main(String[] args) {
        System.out.println('j'+'a'+'v'+'a'); // ascii additions note here. 418
        System.out.println("j"+"a"+"v"+"a"); // java string concat
        System.out.println('0'+2); // ascii value of 0 is 48.. 48+2 -> 50

        char c = 'a';
        System.out.println(c); // a
        System.out.println("Ascii value of a is "+ (int)c); // 97

        System.out.println("Ascii value of A is "+ (int)'A'); //65

        System.out.println("Ascii value of 0 is "+ (int)'0'); //48
        System.out.println("Ascii value of 1 is "+ (int)'1'); // 49

        char c2 = '1';
        System.out.println(c2);//1
        System.out.println(c2+0); // ascii value of 1 i.e. 49 + 0 --> 49

        // As you can see, if you use a char in math addition/etc, then its ascii is used
        // So, how to get actual int value for example, if '1' is there, instead of its ascii 49, I want actual 1.
        // Just subtract 48.. Thats it
        char cWhichWillBeUsedInCompuation = '1';
        System.out.println(cWhichWillBeUsedInCompuation - 48 +2); // I want 1+2..

    }
}
