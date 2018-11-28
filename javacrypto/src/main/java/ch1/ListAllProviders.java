package ch1;

import java.security.Provider;
import java.security.Security;
import java.util.Arrays;

public class ListAllProviders {
    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        Arrays.stream(providers).forEach(
                provider ->  {
                    System.out.println("Provider Namer:"+provider.getName());
                    System.out.println("Provider Info:"+provider.getInfo());
                    System.out.println("Provider Info:"+provider.getVersion());
                    System.out.println(provider);
                }
        );
    }
}
