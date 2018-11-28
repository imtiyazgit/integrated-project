package ch1;

import org.apache.commons.codec.binary.Base64;

import java.security.SecureRandom;
import java.util.Random;

public class SecureRandomEx {
    public static void main(String[] args) {
        byte[] ran = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(ran);

        System.out.println(new String(new Base64().encodeAsString(ran)));


        byte[] ra = new byte[16];
        Random random = new Random();
        random.nextBytes(ra);
        System.out.println(new String(ra));

    }
}
