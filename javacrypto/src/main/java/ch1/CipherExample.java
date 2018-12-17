package ch1;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class CipherExample {


    public static void main(String[] args) throws Exception {
        String clearText = "Login";

        String clearCred = "clearPwd";

        byte[] salt = new byte[32];
        new SecureRandom().nextBytes(salt);


        // The clearPwd you have, make it secretKey using below code.

        SecretKeyFactory method = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(clearCred.toCharArray(), salt, 10000, 128);
        SecretKey secretKey = method.generateSecret(spec);
        SecretKeySpec secretKeySpec =  new SecretKeySpec(secretKey.getEncoded(), "AES");


        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] encryptedText = cipher.doFinal(clearText.getBytes());
        byte[] ivBytes = cipher.getIV();

        System.out.println("EncryptedText="+new Base64().encodeAsString(encryptedText));


        // Decrypt now

        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(ivBytes));

        byte[] plainText = cipher.doFinal(encryptedText);
        System.out.println("ClearText="+new String(plainText));

    }



}
