package com.lambda;

public class LambdaWithFinal {
    int iVar = 1;
    static int sVar = 3;

    void m2() {
        Runnable r = () -> {
          iVar = 3;
        };

    }

    public static void main(String[] args) {
        // Main thread
        int var = 4;

        Runnable r = () -> {
            sVar = 8;
            int var2 = 1 + var;

            System.out.println(var2);
        };


        r.run();
    }
}
