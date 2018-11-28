package ch1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class ClientSignatureVerifying {
    public static void main(String[] args) throws Exception {
        String root = "/Users/imoghal/Documents/personal_projects/integrated-project/javacrypto/src/main/java/ch1";
        byte[] publicKeyBytes;
        X509EncodedKeySpec publicKeySpe;
        KeyFactory keyFactory;
        try (FileInputStream publicKeyFis = new FileInputStream(root + "/distinction-public-key.txt")) {
            publicKeyBytes = new byte[publicKeyFis.available()];
            publicKeyFis.read(publicKeyBytes);
            publicKeyFis.close();
        }

        publicKeySpe = new X509EncodedKeySpec(publicKeyBytes);
        keyFactory = KeyFactory.getInstance("DSA", "SUN");
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpe);

        FileInputStream signatureFis = null;
        byte[] onlySignatureBytes = null;
        try{
            signatureFis = new FileInputStream(root + "/distinction-signature.txt");
            onlySignatureBytes = new byte[signatureFis.available()];
            signatureFis.read(onlySignatureBytes);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            signatureFis.close();
        }

        Signature signature = Signature.getInstance("SHA1withDSA", "SUN");
        signature.initVerify(publicKey);


        try (FileInputStream distinctionFis = new FileInputStream(root + "/distinction.txt")) {
            BufferedInputStream bufin = new BufferedInputStream(distinctionFis);
            byte[] buffer = new byte[8];
            int len;
            while(bufin.available() != 0) {
                len = bufin.read(buffer);
                signature.update(buffer, 0, len);

            }
            bufin.close();

            boolean verifies = signature.verify(onlySignatureBytes);
            System.out.println("Signature matches === "+ verifies);
        }



    }
}
