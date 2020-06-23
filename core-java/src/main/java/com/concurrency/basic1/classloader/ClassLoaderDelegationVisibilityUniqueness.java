package com.concurrency.basic1.classloader;

// Class loader has 3 principles
// 1. Delegation: child asks parent to load the class. Only if parent does not load, child tries to load
// 2. Uniqueness: A class is loaded only once
// 3. Visibility: Child classes can see classes loaded by parent. Not vice versa

public class ClassLoaderDelegationVisibilityUniqueness {
    public static void main(String[] args) {

        ClassLoader cl1 = String.class.getClassLoader();
        System.out.println(cl1); //null

       /* System.out.println("class loader for DNSNameService: "
                + sun.net.spi.nameservice.dns.DNSNameService.class
                .getClassLoader()); //ExtClassLoader*/

        ClassLoader cl = ClassLoaderDelegationVisibilityUniqueness.class.getClassLoader();
        System.out.println(cl); // sun.misc.Launcher$AppClassLoader@3d4eac69

        try {
            Class clazz = Class.forName("com.basic1.classloader.ClassLoaderDelegationVisibilityUniqueness", true, cl.getParent());
            // throws class not found exception, as you are trying to load the class using parent of app class loader
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
