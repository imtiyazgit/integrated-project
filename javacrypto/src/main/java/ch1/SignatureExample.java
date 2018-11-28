package ch1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

public class SignatureExample {
    public static void main(String[] args) throws Throwable {

        String root = "/Users/imoghal/Documents/personal_projects/integrated-project/javacrypto/src/main/java/ch1";

        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA", "SUN");
        keyPairGenerator.initialize(1024, secureRandom);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        Signature dsaSignature = Signature.getInstance("SHA1withDSA", "SUN");
        dsaSignature.initSign(privateKey);

        try (FileInputStream fis = new FileInputStream(root + File.separator +"distinction.txt")) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
            byte[] buffer = new byte[8];
            int len;
            while((len = bufferedInputStream.read(buffer)) >= 0) {
                dsaSignature.update(buffer, 0, len);
            }
            bufferedInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Sign the data
        byte[] realSig = dsaSignature.sign();
        // write this signature to a file
        try (FileOutputStream realSignatureFos = new FileOutputStream(root + "/distinction-signature.txt")) {
            realSignatureFos.write(realSig);
            realSignatureFos.close();
        }

        //Export public key
        byte[] publicKeyBytes = publicKey.getEncoded();
        try (FileOutputStream publicKeyFos = new FileOutputStream(root + "/distinction-public-key.txt")) {
            publicKeyFos.write(publicKeyBytes);
            publicKeyFos.close();
        }


    }
}
