package com.generics;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        new Test().execute();

    }

    public void execute() {
        List<Animal> animals = Arrays.asList(
                new Dog("dog", 4),
                new Hen("hen", 2)
        );
        //AnimalProcessor<Animal> processor = new AnimalProcessorImpl<>();
        //animals.stream().map(animal -> animal.getName() +" with legs "+ animal.getLegs()).forEach(System.out::println);
        processAnimals(animals, ani -> ani.getLegs()+"");
    }

    public void processAnimals(List<Animal> animals, AnimalProcessor processor) {
        animals.stream().map(animal->processor.sayName(animal)).forEach(System.out::println);
    }
}
