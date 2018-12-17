package ch1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

//keytool -genkey -alias imtiyaz.com -keyalg RSA -keystore imtiyaz-store.jks -storepass password

public class KeyStoreExample {
    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("jks");
        char[] keyStorePassword = "password".toCharArray();
        try(InputStream keyStoreData = new FileInputStream(System.getProperty("user.dir") + "/javacrypto/src/main/java/ch1/imtiyaz-store.jks")){
            keyStore.load(keyStoreData, keyStorePassword);

            KeyStore.PasswordProtection pp =
                    new KeyStore.PasswordProtection(keyStorePassword);


            KeyStore.Entry entry = keyStore.getEntry("imtiyaz.com", pp);

            System.out.println(entry);

        }

    }
}
