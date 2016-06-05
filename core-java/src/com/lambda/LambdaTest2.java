package com.lambda;

/**
 * Created by imtiyaz on 6/4/16.
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        run(() -> System.out.println("Test"));

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anoter runnable");
            }
        };

        run(r2);
    }

    static void run(Runnable runnable) {
        runnable.run();
    }
}
