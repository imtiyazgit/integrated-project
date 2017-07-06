package com.accion.labs.test1;

import jersey.repackaged.com.google.common.primitives.Ints;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by imtiyaz on 7/5/17.
 */
public class IntRandomGenerator {
    private int limit;
    private int low;
    private int high;
    private int[] randNumbers;
    private Set<Integer> dups;
    private boolean dupsPopulated;


    public IntRandomGenerator(int limit, int low, int high) {
        this.limit = limit;
        this.low = low;
        this.high = high;
    }

    public void generateInts() {
        randNumbers = new Random().ints(limit, low, high).toArray();
    }

    public int[] getRandNumbers() {
        return randNumbers;
    }

    private void populateDups() {
        if (dupsPopulated) return;
        List<Integer> list = IntStream.of(randNumbers).boxed().collect(Collectors.toList());
        this.dups = list.stream().filter(i -> Collections.frequency(list, i) >1)
                .collect(Collectors.toSet());
    }

    public boolean isDupsExist() {
        return this.dups != null && this.dups.size() > 0;
    }

    public int findAndPrintDups() {
        populateDups();
        dups.forEach(System.out::println);
        return dups.size();
    }
}
