package com.generics;

@FunctionalInterface
public interface AnimalProcessor<T extends Animal> {
    String sayName(T t);

    /**package com.generics;

     public class AnimalProcessorImpl<T extends Animal> implements AnimalProcessor<T> {

    @Override
    public String sayName(Animal animal) {
    return animal.getName() +" with legs "+ animal.getLegs();
    }
    }
**/
     }
