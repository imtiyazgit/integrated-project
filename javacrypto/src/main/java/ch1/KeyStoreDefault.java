package ch1;

import java.security.KeyStore;

public class KeyStoreDefault {
    public static void main(String[] args) throws Exception {
        KeyStore ks =  KeyStore.getInstance(KeyStore.getDefaultType());
        System.out.println(ks);

        KeyStore ksApple =  KeyStore.getInstance("KeychainStore", "Apple");
        System.out.println(ksApple);

    }
}
