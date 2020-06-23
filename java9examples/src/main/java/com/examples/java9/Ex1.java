package com.examples.java9;

import java.beans.ConstructorProperties;
import java.lang.annotation.Annotation;
import java.util.Arrays;
//import java.util.stream.Collectors;

@CustomAnnotation(description = "This class gets annotations and prints")
public class Ex1 {
    /*public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.examples.java9.Ex1");

        Module module = clazz.getModule();

        new Ex1().process(module);
    }

    public void process(Module module) {

        String annotations = Arrays.stream(module.getDeclaredAnnotations())
                .map(Annotation::annotationType)
                .map(Object::toString)
                .collect(Collectors.joining(","));


        System.out.println(annotations);

    }*/
}
