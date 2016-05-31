package com.basic1;

/**
 * Created by SG0222221 on 1/17/2016.
 */
public class IncrementDecrementStuff {

    public static int getX(int x) {
        return x++;
    }

    public static int getY(int y) {
        return --y;
    }

    public static void main(String[] args) {
        System.out.println(getX(10));
        System.out.println(getY(10));
    }
}
