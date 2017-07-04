package main.java.com.concurrency.basic1.classloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


/**
 * This class loader loads the classes from the package com.basic1.classloader and
 * any other class will be loaded using parent class loaders
 */

class CustomClassLoader extends ClassLoader {
    public CustomClassLoader(ClassLoader parent) {
        super(parent);
    }

    // this method tries to load the class from the given package in custom way
    private Class getClassInCustomWay(String name) {
        String file = name.replace('.', File.separatorChar) +".class";
        DataInputStream in = null;
        try {
            InputStream stream = getClass().getClassLoader().getResourceAsStream(
                    file);
            int size = stream.available();
            byte buff[] = new byte[size];
            in = new DataInputStream(stream);
            in.readFully(buff);
            // defineClass is inherited from the ClassLoader class
            // that converts byte array into a Class. defineClass is Final
            // so we cannot override it
            Class c = defineClass(name, buff, 0, buff.length);
            resolveClass(c);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Class is unable to find by our custom loader");
        return null;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("Loading class -> "+name);
        if (name.startsWith("com.basic1.classloader")) {
            return getClassInCustomWay(name);
        }
        return super.loadClass(name);
    }
}

public class CustomClassLoaderTest{
    public static void main(String[] args) throws Exception {
        Class c=Class.forName("com.basic1.classloader.DummyClass");
        DummyClass s=(DummyClass)c.newInstance();
        s.print(" Baig");

        CustomClassLoader customClassLoader = new CustomClassLoader(CustomClassLoaderTest.class.getClassLoader());
        Class clazz = customClassLoader.loadClass("com.basic1.classloader.DummyClass");
        s=(DummyClass)c.newInstance();
        s.print(" Baig");
    }
}
