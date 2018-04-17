package com.lambda;

import java.util.function.IntBinaryOperator;

public class IntBinaryLambdaExample {
    public static void main(String[] args) {
        int i1 = 2;
        int i2 =3;

        IntBinaryOperator lambda = (int left, int right) -> left + right ;
        System.out.println(lambda.applyAsInt(i1, i2));
    }
}
