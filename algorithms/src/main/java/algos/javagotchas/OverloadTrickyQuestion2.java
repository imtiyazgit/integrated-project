package algos.javagotchas;

public class OverloadTrickyQuestion2 {
    public static void main(String[] args) {
        foo(null);
    }
    public static void foo(Object o) {
        System.out.println("Object impl");
    }
    public static void foo(String s) {
        System.out.println("String impl");
    }

    // If you uncomment below code, it wont compile
    /*public static void foo(StringBuffer i){
        System.out.println("StringBuffer impl");
    }*/

}
