package com.lambda;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> supplierLambda = () -> 2;

        System.out.println(supplierLambda.get());
    }
}
