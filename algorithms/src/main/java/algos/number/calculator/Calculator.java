package algos.number.calculator;

import java.util.Scanner;

/**
 * Problem: Given two doubles and operator on commandline, use scanner and perform operation and return result
 * 3
 * 6
 * +
 * This should return 9
 */

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        char c = scanner.next().charAt(0);

        switch(c) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;
            default:
                System.out.println("Unknown operator found");

        }

    }
}
