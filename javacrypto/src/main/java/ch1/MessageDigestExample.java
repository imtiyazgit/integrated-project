package ch1;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

public class MessageDigestExample {
    public static void main(String[] args) throws Exception {

        String str = "Hello";

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] digest = messageDigest.digest(str.getBytes());
        System.out.println(new Base64().encodeToString(digest));


    }
}
