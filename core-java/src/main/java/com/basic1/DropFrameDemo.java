package com.basic1;

public class DropFrameDemo
{
    private static int state = 0;

    public static void main(final String[] args)
    {
        modifyStateBasedOnParameter(state);
        modifyStateBasedOnStaticField();
    }

    // dropping frame within this method,
    // and executing again will print state = 2
    private static void modifyStateBasedOnStaticField()
    {
        state++;
        System.out.println("state = " + state);
    }

    // dropping frame from within this method,
    // and executing again will print state = 1
    private static void modifyStateBasedOnParameter(final int parameter)
    {
        state = parameter + 1;
        System.out.println("state = " + state);
    }
}
