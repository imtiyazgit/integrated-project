package algos.string.sinusoidal;

import org.w3c.dom.ls.LSOutput;

import java.security.spec.RSAOtherPrimeInfo;

public class PrintSinusoidal {

    // Hello world!
    // following is the wave first row, second row, third row
    //   e       _       l
    // H   l   o   w   r   d
    //       l       o        !
    private static String sinusoidalWave(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < s.length(); i = i +4) {
            result.append(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i = i+2) {
            result.append(s.charAt(i));
        }

        for (int i = 3; i < s.length() ; i = i + 4) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(sinusoidalWave("Hello world!"));
    }
}
