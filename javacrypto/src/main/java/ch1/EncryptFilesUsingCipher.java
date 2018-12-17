package ch1;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EncryptFilesUsingCipher {
    public static void main(String[] args) throws Exception {

            byte[] ivBytes = new byte[16];
            byte[] salt = new byte[32];
            String keyClear = "clearPwd";

            ivBytes = new Base64().decode(new String("aXZCeXRlcw==")); //ivBytes
            salt = new Base64().decode(new String("c2FsdA==")); //salt

            // The clearPwd you have, make it secretKey using below code.

            SecretKeyFactory method = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            PBEKeySpec spec = new PBEKeySpec(keyClear.toCharArray(), salt, 10000, 128);
            SecretKey secretKey = method.generateSecret(spec);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            FileInputStream fis = null;
            FileOutputStream fos = null;
            CipherInputStream cis = null;

        try {
            fis = new FileInputStream("/Users/imoghal/Documents/personal_projects/integrated-project/javacrypto/src/main/java/ch1/hello-world.txt");
            cis = new CipherInputStream(fis, cipher);
            fos = new FileOutputStream("/Users/imoghal/Documents/personal_projects/integrated-project/javacrypto/src/main/java/ch1/hello-world-encrypted.txt");

            byte[] b = new byte[8];
            int i=cis.read(b);

            while(i!=-1) {
                fos.write(b, 0, i);
                i = cis.read(b);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            fos.close();
            cis.close();

        }

    }
}
